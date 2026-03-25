import React from "react";

function ExampleSelector({ program, setProgram, examples }) {
    return (
        <select
            onChange={(e) => setProgram(e.target.value)}
            value={program}
        >
            {examples.map((ex, index) => (
                <option key={index} value={ex.value}>
                    {ex.label}
                </option>
            ))}
        </select>
    );
}

export default ExampleSelector;