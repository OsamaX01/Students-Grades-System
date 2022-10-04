package com.example.showApp.authentication;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationWebClient {
    private final WebClient webClient;

    public AuthenticationWebClient() {
        this.webClient = WebClient.create("http://AuthenticationApp:7070");
    }

    public Mono<Boolean> getOne() {
        return webClient.get()
                .uri("/auth")
                .retrieve()
                .bodyToMono(Boolean.class);
    }

    public Mono<Boolean> postOne(User user) {
        return webClient.post()
                .uri("/auth")
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(Boolean.class);
    }
}