import './App.css';
import {useState} from "react";

function App() {
    const URL = window.location.origin.split(':3000')[0] + ':8083';
    const [program, setProgram] = useState('');

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

            if (response.ok) {
                await runProgram();
            } else {
                outputBox.innerText = "validateProgram(): Network response was not ok.";
            }
        } catch (error) {
            outputBox.innerText = "validateProgram(): There was a problem with the fetch operation:\n" + error.message;
        }
    }

    async function runProgram() {
        const outputBox = document.getElementById("output-box");

        try {
            const response = await fetch(
                URL+`/api/v1/simulate/${encodeURIComponent(program)}`,
                {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                    },
                }
            );

            if (response.ok) {
                const responseText = await response.text();
                outputBox.innerText = responseText;
            } else {
                outputBox.innerText = "runProgram(): Network response was not ok.";
            }
        } catch (error) {
            outputBox.innerText = "runProgram(): There was a problem with the fetch operation:\n" + error.message;
        }
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
                    <h3>Output:</h3>
                    <div id="output-box"></div>
                </div>
            </div>
        </div>
    );
}

export default App;
