import React from "react";

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
                            <pre>{row.tokens.join(" ")}</pre>
                        </td>
                        <td>
                                <pre>
                                    {isError
                                        ? row.stack.join("\n")
                                        : row.stack
                                            .map((v) => `[s${index}] ${v}`)
                                            .join("\n")}
                                </pre>
                        </td>
                    </tr>
                );
            })}
            </tbody>
        </table>
    );
}

export default OutputTable;