import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {login} from "../services/api";

function LoginPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate();

    async function handleLogin() {
        try {
            const data = await login(username, password);

            localStorage.setItem("token", data.token);
            navigate("/admin");

        } catch (e) {
            setError(e.message || "Server error");
        }
    }

    return (
        <div className="login-container">
            <div className="login-box">
                <h2>Login</h2>

                <input
                    placeholder="Username"
                    value={username}
                    onChange={e => setUsername(e.target.value)}
                />

                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                />

                <button onClick={handleLogin}>Login</button>

                {error && <p style={{color: "red"}}>{error}</p>}
            </div>
        </div>
    );
}

export default LoginPage;