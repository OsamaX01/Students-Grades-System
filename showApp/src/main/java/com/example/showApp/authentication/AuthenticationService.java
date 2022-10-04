package com.example.showApp.authentication;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationWebClient reactiveWebClient;

    public AuthenticationService(AuthenticationWebClient reactiveWebClient) {
        this.reactiveWebClient = reactiveWebClient;
    }

    public void authenticate(User user){
        reactiveWebClient.postOne(user).block();
    }

    public boolean isAuthenticated() {
        return reactiveWebClient.getOne().block();
    }
}