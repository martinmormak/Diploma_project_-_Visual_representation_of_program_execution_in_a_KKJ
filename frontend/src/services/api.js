const backendURL = process.env.REACT_APP_BACKEND_URL;

export async function validate(program) {
    return fetch(`${backendURL}/api/v1/validate`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ tokensValue: program }),
    });
}

export async function simulateFromScratch(program) {
    return fetch(`${backendURL}/api/v1/simulate/from-scratch`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ tokensValue: program }),
    });
}

export async function simulateFromPoint(tokens, stack) {
    return fetch(`${backendURL}/api/v1/simulate/from-point`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            tokensValue: tokens,
            stackValue: stack
        }),
    });
}