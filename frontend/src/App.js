import './App.css';
import {useState, useRef} from "react";

function App() {
    const backendURL = window.location.origin.split(':3000')[0] + ':8083';
    const [program, setProgram] = useState('');
    const [output, setOutput] = useState([]);
    const [visibleLines, setVisibleLines] = useState(0);
    const fileInputRef = useRef(null);

    const examples = [
        {
            label: "— Select an example —",
            value: ""
        },
        {
            label: "Example 1: Simple program",
            value: "5 3 ADD"
        },
        {
            label: "Example 2: Stack ops",
            value: "10 DUP MUL"
        },
        {
            label: "Example 3: Invalid program",
            value: "1 ADD"
        }
    ];

    async function handleInputChange(event) {
        setProgram(event.target.value);
    }

    async function handleExampleChange(event) {
        setProgram(event.target.value);
    }

    function saveToFile() {
        const element = document.createElement("a");
        const file = new Blob([program], {
            type: "text/plain"
        });
        element.href = URL.createObjectURL(file);
        element.download = "kkjProgram.txt";
        document.body.appendChild(element);
        element.click();
    }

    function loadFromFile(event) {const file = event.target.files[0];
        if (!file) return;

        const reader = new FileReader();
        reader.onload = (e) => {
            setProgram(e.target.result);
        };
        reader.readAsText(file);

        // allow loading the same file again
        event.target.value = null;
    }

    function exportTableToFile() {
        const csv = [
            ["Tokens", "Stack"], // header row
            ...output.map((row, rowIndex) => [
                row.tokens.join(" "),
                row.stack
                    .map(value => `[s${rowIndex}] ${value}`)
                    .join(" | ")
            ])
        ]
            .map(row =>
                row.map(value => `"${value.replace(/"/g, '""')}"`).join(",")
            )
            .join("\n");

        const element = document.createElement("a");
        const file = new Blob([csv], { type: "text/csv;charset=utf-8;" });

        element.href = URL.createObjectURL(file);
        element.download = "kkjTable.csv";

        document.body.appendChild(element);
        element.click();
        document.body.removeChild(element);
    }

    async function validateProgram() {
        try {
            const response = await fetch(
                backendURL+`/api/v1/validate/${encodeURIComponent(program)}`,
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ input: program }),
                }
            );

            if (response.ok === true) {
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
                backendURL + `/api/v1/simulate/${encodeURIComponent(program)}`,
                { method: "GET" }
            );

            if (response.ok) {
                const data = await response.json();
                setOutput(data);
                setVisibleLines(1);
            } else {
                setOutput([{ tokens: ["ERROR"], stack: ["Network response was not ok"] }]);
                setVisibleLines(1);
            }
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
                {rows.map((row, index) => {
                    const isError = row.tokens.includes("ERROR");

                    return (
                    <tr key={index}>
                        <td>
                            <pre>
                                {row.tokens.join(" ")}
                            </pre>
                        </td>
                        <td>
                            <pre>
                                {isError
                                    ? row.stack.join("\n")
                                    : row.stack.map((v) => `[s${index}] ${v}`).join("\n")}
                            </pre>
                        </td>
                    </tr>
                    )})}
                </tbody>
            </table>
        );
    }

    return (
        <div className="App">
            <div className="body">
                <h1>KKJ validator</h1>
                <div className="input-section">
                    <select
                        onChange={handleExampleChange}
                        value={program}
                    >
                        {examples.map((ex, index) => (
                            <option key={index} value={ex.value}>
                                {ex.label}
                            </option>
                        ))}
                    </select>
                    <textarea
                        id="user-input"
                        placeholder="Write your program here..."
                        value={program}
                        onChange={handleInputChange}
                    ></textarea>
                    <div className="input-buttons">
                        <button onClick={validateProgram}>Run</button>
                        <button onClick={saveToFile}>Save program to file</button>
                        <button onClick={() => fileInputRef.current.click()}>Load program from file</button>
                    </div>
                    <input
                        type="file"
                        accept=".txt"
                        ref={fileInputRef}
                        style={{ display: "none" }}
                        onChange={loadFromFile}
                    />
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
                            <button onClick={exportTableToFile}>Export table</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;
