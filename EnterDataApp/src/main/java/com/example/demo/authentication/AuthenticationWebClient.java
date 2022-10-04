package com.example.demo.authentication;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationWebClient {
    private final WebClient webClient;

    public AuthenticationWebClient() {
        this.webClient = WebClient.create("http://AuthenticationApp:7070");
    }

    public Mono<Boolean> callOne(User user) {
        return webClient.post()
                .uri("/auth")
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(Boolean.class);
    }
}