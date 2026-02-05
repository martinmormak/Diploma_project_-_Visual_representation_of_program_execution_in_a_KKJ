import './App.css';
import {useState} from "react";

function App() {
    const URL = window.location.origin.split(':3000')[0] + ':8083';
    const [program, setProgram] = useState('');
    const [output, setOutput] = useState([]);
    const [visibleLines, setVisibleLines] = useState(0);

    async function handleInputChange(event) {
        setProgram(event.target.value);
    }

    async function validateProgram() {
        const outputBox = document.getElementById("output-box");

        try {
            const response = await fetch(
                URL+`/api/v1/validate/${encodeURIComponent(program)}`,
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ input: program }),
                }
            );

            console.log(response);
            console.log(response.ok);
            if (response.ok == true) {
                await runProgram();
            } else {
                setOutput([{ tokens: ["ERROR"], stack: ["validateProgram(): Network response was not ok."] }]);
                setVisibleLines(1);
            }
        } catch (error) {
            setOutput([{ tokens: ["ERROR"], stack: [error.message] }]);
            setVisibleLines(1);
        }
    }

    async function runProgram() {
        try {
            const response = await fetch(
                URL + `/api/v1/simulate/${encodeURIComponent(program)}`,
                { method: "GET" }
            );

            if (!response.ok) {
                throw new Error("Network response was not ok");
            }

            const data = await response.json();
            setOutput(data);
            setVisibleLines(1);
        } catch (error) {
            setOutput([{ tokens: ["ERROR"], stack: [error.message] }]);
            setVisibleLines(1);
        }
    }

    function OutputTable({ data, visibleLines }) {
        const rows = data.slice(0, visibleLines);

        return (
            <table className="output-table">
                <thead>
                <tr>
                    <th>Tokens</th>
                    <th>Stack</th>
                </tr>
                </thead>
                <tbody>
                {rows.map((row, index) => (
                    <tr key={index}>
                        <td>{row.tokens.join(" ")}</td>
                        <td>{row.stack.join(" ")}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        );
    }

    return (
        <div className="App">
            <div className="body">
                <h1>KKJ validator</h1>
                <div className="input-section">
                    <textarea
                        id="user-input"
                        placeholder="Write your program here..."
                        value={program}
                        onChange={handleInputChange}
                    ></textarea>
                    <button onClick={validateProgram}>Run</button>
                </div>

                <div className="output-section">
                    <div className="output-screen">
                        <h3>Output:</h3>
                        <div className="table-wrapper">
                            <OutputTable
                                data={output}
                                visibleLines={visibleLines}
                            />
                        </div>
                    </div>
                    <div className="output-buttons">
                        <div className="top-buttons">
                            <button
                                onClick={() =>
                                    setVisibleLines((n) => Math.max(1, n - 1))
                                }
                            >
                                Previous
                            </button>
                            <button
                                onClick={() =>
                                    setVisibleLines((n) =>
                                        Math.min(output.length, n + 1)
                                    )
                                }
                            >
                                Next
                            </button>
                        </div>
                        <div className="bottom-button">
                            <button
                                onClick={() =>
                                    setVisibleLines(output.length)
                                }
                            >
                                Show all
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;
