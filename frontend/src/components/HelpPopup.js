import React from "react";

function HelpPopup() {
    return (
        <div className="help-popup">
            <strong>KKJ Commands</strong>

            <ul>
                <li><b>ADD</b> – add top two numbers</li>
                <li><b>SUB</b> – subtract second from top</li>
                <li><b>MUL</b> – multiply top two numbers</li>
                <li><b>CMP</b> – compare top two numbers</li>

                <li><b>NOT</b></li>
                <li><b>AND</b></li>
                <li><b>ISNEG</b></li>
                <li><b>ISPOS</b></li>

                <li><b>CLEAR</b></li>
                <li><b>OVER</b></li>
                <li><b>POP</b></li>
                <li><b>DUP</b></li>
                <li><b>SWAP</b></li>
                <li><b>ROTL</b></li>
                <li><b>ID</b></li>

                <li><b>{`{ ... }`}</b></li>
                <li><b>APPLY</b></li>
                <li><b>APPLYOVER</b></li>
                <li><b>COMPOSE</b></li>

                <li><b>CHOOSE</b></li>
                <li><b>WHILE</b></li>
            </ul>

            <hr />

            <p><b>Example:</b></p>
            <code>3 4 add → 7</code>
        </div>
    );
}

export default HelpPopup;