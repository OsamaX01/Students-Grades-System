package com.example.demo.authentication;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthenticationService {
    private boolean isAuthenticated = false;
    private final AuthenticationWebClient reactiveWebClient;

    public AuthenticationService(AuthenticationWebClient reactiveWebClient) {
        this.reactiveWebClient = reactiveWebClient;
    }

    public void authenticate(User user){
        isAuthenticated = reactiveWebClient.callOne(user).block();
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}