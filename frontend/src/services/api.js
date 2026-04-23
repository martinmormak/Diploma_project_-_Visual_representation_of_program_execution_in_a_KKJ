const backendURL = process.env.REACT_APP_BACKEND_URL || "";

function getAuthHeaders() {
    const token = localStorage.getItem("token");

    return {
        "Content-Type": "application/json",
        ...(token && { Authorization: `Bearer ${token}` })
    };
}

export async function login(username, password) {
    const res = await fetch(`${backendURL}/api/v1/login`, {
        method: "POST",
        headers: getAuthHeaders(),
        body: JSON.stringify({ username, password })
    });

    if (!res.ok) {
        throw new Error("Invalid credentials");
    }

    return res.json();
}

export async function getStatus() {
    const res = await fetch(`${backendURL}/api/v1/status`, {
        headers: getAuthHeaders()
    });

    if (!res.ok) {
        throw new Error("Failed to fetch status");
    }

    return res.json();
}

export async function toggleStatus() {
    const res = await fetch(`${backendURL}/api/v1/toggle`, {
        method: "POST",
        headers: getAuthHeaders()
    });

    if (!res.ok) {
        throw new Error("Failed to toggle");
    }

    return res.json();
}

export async function validate(program) {
    return fetch(`${backendURL}/api/v1/validate`, {
        method: "POST",
        headers: getAuthHeaders(),
        body: JSON.stringify({ tokensValue: program }),
    });
}

export async function simulateFromScratch(program) {
    return fetch(`${backendURL}/api/v1/simulate/from-scratch`, {
        method: "POST",
        headers: getAuthHeaders(),
        body: JSON.stringify({ tokensValue: program }),
    });
}

export async function simulateFromPoint(tokens, stack) {
    return fetch(`${backendURL}/api/v1/simulate/from-point`, {
        method: "POST",
        headers: getAuthHeaders(),
        body: JSON.stringify({
            tokensValue: tokens,
            stackValue: stack
        }),
    });
}