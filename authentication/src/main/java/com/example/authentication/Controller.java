package com.example.authentication;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private boolean isAuthenticated = false;

    @GetMapping("/auth")
    public boolean authenticate() {
        return isAuthenticated;
    }

    @PostMapping("/auth")
    public boolean authenticate(@RequestBody User user) {
        if (user.getUsername().equals("root") && user.getPassword().equals("123456")) {
            isAuthenticated = true;
        }
        return isAuthenticated;
    }
}
