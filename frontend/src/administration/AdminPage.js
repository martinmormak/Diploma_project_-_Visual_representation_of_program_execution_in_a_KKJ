import {useEffect, useState} from "react";
import {getStatus, toggleStatus} from "../services/api";
import { useNavigate } from "react-router-dom";

function AdminPage() {
    const [isActive, setIsActive] = useState(null);
    const navigate = useNavigate();

    async function fetchStatus() {
        try {
            const data = await getStatus();
            setIsActive(data.active);
        } catch (e) {
            console.error(e);
        }
    }

    async function handleToggle() {
        try {
            const data = await toggleStatus();
            setIsActive(data.active);
        } catch (e) {
            console.error(e);
        }
    }

    function handleLogout() {
        localStorage.removeItem("token");

        navigate("/login");
    }

    useEffect(() => {
        fetchStatus();
    }, []);

    return (
        <div className="admin-container">
            <h2>Admin panel</h2>

            <div>
                Status:
                <span
                    className={`status-indicator ${
                        isActive ? "status-active" : "status-inactive"
                    }`}
                >
                    {isActive ? "ACTIVE" : "INACTIVE"}
                </span>
            </div>

            <button className="toggle-btn" onClick={handleToggle}>
                Turn {isActive ? "OFF" : "ON"}
            </button>

            <button className="logout-btn" onClick={handleLogout}>
                Logout
            </button>
        </div>
    );
}

export default AdminPage;