import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import AdminPage from "./administration/AdminPage";
import ProtectedRoute from "./administration/ProtectedRoute";
import LoginPage from "./administration/LoginPage";

function Root() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<App />} />
                <Route path="/login" element={<LoginPage />} />
                <Route
                    path="/admin"
                    element={
                        <ProtectedRoute>
                            <AdminPage />
                        </ProtectedRoute>
                    }
                />
            </Routes>
        </BrowserRouter>
    );
}

export default Root;