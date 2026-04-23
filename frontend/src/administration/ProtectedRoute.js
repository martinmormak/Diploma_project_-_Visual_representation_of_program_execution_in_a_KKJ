import { Navigate } from "react-router-dom";

function ProtectedRoute({ children }) {
    const token = localStorage.getItem("token");

    if (!token && token!=='') {
        localStorage.getItem("token")
        return <Navigate to="/login" />;
    }

    return children;
}

export default ProtectedRoute;