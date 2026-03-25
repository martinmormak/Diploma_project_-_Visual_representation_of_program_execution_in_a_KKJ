import React from "react";

function HelpPopup() {
    return (
        <div className="help-popup">
            <strong>KKJ Commands</strong>

            <ul>
                <li><b>ADD</b> – add top two numbers</li>
                <li><b>SUB</b> – subtract top from second (second − top)</li>
                <li><b>MUL</b> – multiply top two numbers</li>
                <li><b>CMP</b> – compare top two numbers</li>

                <li><b>NOT</b> – logical negation of top value</li>
                <li><b>AND</b> – logical AND of top two values</li>
                <li><b>ISNEG</b> – check if top value is negative</li>
                <li><b>ISPOS</b> – check if top value is positive</li>

                <li><b>CLEAR</b> – clear the stack</li>
                <li><b>OVER</b> – copy second item to top</li>
                <li><b>POP</b> – remove top item</li>
                <li><b>DUP</b> – duplicate top item</li>
                <li><b>SWAP</b> – swap top two items</li>
                <li><b>ROTL</b> – rotate stack elements left</li>
                <li><b>ID</b> – identity (no operation)</li>

                <li><b>{`{ ... }`}</b> – quotation (code block)</li>
                <li><b>APPLY</b> – execute quotation</li>
                <li><b>APPLYOVER</b> – execute quotation preserving original value</li>
                <li><b>COMPOSE</b> – combine two quotations</li>

                <li><b>CHOOSE</b> – conditional execution (if-else)</li>
                <li><b>WHILE</b> – loop while condition holds</li>
            </ul>

            <hr />

            <p><b>Example:</b></p>
            <code>3 4 add → 7</code>
        </div>
    );
}

export default HelpPopup;