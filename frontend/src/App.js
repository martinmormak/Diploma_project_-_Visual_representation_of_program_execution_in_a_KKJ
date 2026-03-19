import './App.css';
import {useState, useRef, useEffect} from "react";

function App() {
    const backendURL = process.env.REACT_APP_BACKEND_URL;
    const [program, setProgram] = useState('');
    const [output, setOutput] = useState([]);
    const [visibleLines, setVisibleLines] = useState(0);
    const fileInputRef = useRef(null);
    const tableWrapperRef = useRef(null);

    const examples = [
        {
            label: "— Select an example —",
            value: ""
        },

        {
            label: "Example 1: Simple arithmetic",
            value: "3 4 add"
        },

        {
            label: "Example 2: Arithmetic + stack ops",
            value: "3 4 add dup mul"
        },

        {
            label: "Example 3: Using stack manipulation",
            value: "5 6 swap sub"
        },
        {
            label: "Example 4: Conditional choose",
            value: "0 ispos 5 6 choose"
        },

        {
            label: "Example 5: Composition with quotations",
            value: "14 {dup dup} {add add} compose apply"
        },

        {
            label: "Example 6: Invalid program (stack underflow)",
            value: "1 add"
        },

        {
            label: "Example 7: Countdown with while",
            value: "5 {dup 0 gt} {dup 1 sub} while"
        },

        {
            label: "Example 8: Factorial (iterative)",
            value: "5 1 swap {dup 1 gt} {swap over mul swap 1 sub} while pop"
        },

        {
            label: "Example 9: Sum from N down to 1",
            value: "5 0 swap {dup 0 gt} {swap over add swap 1 sub} while pop"
        },

        {
            label: "Example 10: Double until > 100",
            value: "1 {dup 100 lt} {dup add} while"
        },

        {
            label: "Example 11: Nested while",
            value: "3 {dup 0 gt} {2 {dup 0 gt} {1 sub} while 1 sub} while"
        },

        {
            label: "Example 12: Infinite loop (logical error)",
            value: "1 {dup 0 gt} {dup} while"
        },

        {
            label: "Example 13: Invalid while (missing quotation)",
            value: "5 dup 0 gt {1 sub} while"
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

    useEffect(() => {
        if (tableWrapperRef.current) {
            tableWrapperRef.current.scrollTo({
                top: tableWrapperRef.current.scrollHeight,
                behavior: "smooth"
            });
        }
    }, [visibleLines]);

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

    function tryContinueExecution(newVisibleLines) {
        if (newVisibleLines > output.length) return;

        const lastRow = output[newVisibleLines - 1];

        if (
            lastRow &&
            lastRow.tokens &&
            lastRow.tokens.join("").trim() !== "" &&
            lastRow.tokens.join("").trim() !== "ERROR"
        ) {
            runProgramFromPoint(
                lastRow.tokens.join(" "),
                lastRow.stack.join(" ")
            );
        }
    }

    async function validateProgram() {
        try {
            const response = await fetch(
                backendURL+`/api/v1/validate`,
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ tokensValue: program }),
                }
            );

            if (response.ok === true) {
                await runProgramFromScratch();
            } else {

                const errorText = await response.text();
                setOutput([{ tokens: ["ERROR"], stack: [errorText] }]);
                setVisibleLines(1);
            }
        } catch (error) {
            setOutput([{ tokens: ["ERROR"], stack: [error.message] }]);
            setVisibleLines(1);
        }
    }

    async function runProgramFromScratch() {
        try {
            const response = await fetch(
                backendURL + `/api/v1/simulate/from-scratch`,
                {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json",
                        },
                        body: JSON.stringify({
                            tokensValue: program
                        }),
                    }
            );

            if (response.ok) {
                const data = await response.json();
                setOutput(data);
                setVisibleLines(1);
            } else {
                const errorText = await response.text();
                setOutput([{ tokens: ["ERROR"], stack: [errorText] }]);
                setVisibleLines(1)
            }
        } catch (error) {
            setOutput([{ tokens: ["ERROR"], stack: [error.message] }]);
            setVisibleLines(1);
        }
    }

    async function runProgramFromPoint(tokens, stack) {
        try {
            const response = await fetch(
                backendURL + `/api/v1/simulate/from-point`,
                {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json",
                        },
                        body: JSON.stringify({
                            tokensValue: tokens,
                            stackValue: stack
                        }),
                    }
            );

            if (response.ok) {
                const data = await response.json();
                setOutput(prev => [...prev, ...data]);
                setVisibleLines(n => n + 1);
            } else {
                const errorText = await response.text();
                setOutput(prev => [...prev, { tokens: ["ERROR"], stack: [errorText] }]);
                setVisibleLines(n => n + 1);
            }
        } catch (error) {
            setOutput(prev => [...prev, { tokens: ["ERROR"], stack: [error.message] }]);
            setVisibleLines(n => n + 1);
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
                        <div className="table-wrapper" ref={tableWrapperRef}>
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
                                    setVisibleLines((n) => {
                                        const newValue = Math.min(output.length, n + 1);

                                        if (newValue === output.length) {
                                            tryContinueExecution(newValue);
                                        }

                                        return newValue;
                                    })
                                }
                            >
                                Next
                            </button>
                        </div>
                        <div className="bottom-button">
                            <button
                                onClick={() => {
                                    const newValue = output.length;
                                    setVisibleLines(newValue);
                                    tryContinueExecution(newValue);
                                }}
                            >
                                Show all states
                            </button>
                            <button onClick={exportTableToFile}>Export table with states</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;
