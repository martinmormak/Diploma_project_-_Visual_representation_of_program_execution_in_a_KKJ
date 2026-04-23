package org.server.services;

import org.springframework.stereotype.Service;

@Service
public class AppStateService {

    private boolean state = true;

    public boolean isActive() {
        return state;
    }

    public boolean toggle() {
        state = !state;
        return state;
    }
}
