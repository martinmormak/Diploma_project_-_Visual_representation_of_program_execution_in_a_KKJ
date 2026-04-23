package org.server.controllers;

import io.jsonwebtoken.security.Keys;
import org.server.JSON.LoginRequestJSON;
import org.server.services.AppStateService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;


import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AdministrationController {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final AppStateService appStateService;

    private final Map<String, String> users = new HashMap<>();

    private final SecretKey key = Keys.hmacShaKeyFor("KKJ_server_secret_key_for_HTTPS_comunication".getBytes());

    public AdministrationController(AppStateService appStateService) {
        this.appStateService = appStateService;

        users.put("admin", "$2a$10$c28esnILQV3PR.E20NXBIOP.VYk7EhiWDClC5NPVkLQjfR/AHaFGC"); //users.put("username", passwordEncoder.encode("password_plaincode"));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> validateLoginCredentials(@RequestBody LoginRequestJSON request) {
        String storedHash = users.get(request.username);

        if (storedHash == null) {
            return ResponseEntity.status(401).build();
        }

        boolean matches = passwordEncoder.matches(request.password, storedHash);

        if (!matches) {
            return ResponseEntity.status(401).build();
        }

        String token = generateToken(request.username);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Boolean>> appStatus(@RequestHeader("Authorization") String token) {
        if (!isValid(extractToken(token))) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(Map.of("active", appStateService.isActive()));
    }

    @PostMapping("/toggle")
    public ResponseEntity<Map<String, Boolean>> appToggle(@RequestHeader("Authorization") String token) {
        if (!isValid(extractToken(token))) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(Map.of("active", appStateService.toggle()));
    }

    private String extractToken(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.substring(7);
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1h
                .signWith(key)
                .compact();
    }

    public boolean isValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}