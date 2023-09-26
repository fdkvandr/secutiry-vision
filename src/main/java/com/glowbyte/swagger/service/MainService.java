package com.glowbyte.swagger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MainService {

    private final RestTemplate restTemplate;
    @Value("${sv-param.default-url}")
    private final String defaultUrl;

    public ResponseEntity<?> getMethod(String path, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("sv-token", token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(defaultUrl + path, HttpMethod.GET, entity, String.class);
    }

    public ResponseEntity<?> postMethod(String path, String request, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("sv-token", token);
        HttpEntity<String> entity = new HttpEntity<>(request, headers);
        return restTemplate.exchange(defaultUrl + path, HttpMethod.POST, entity, String.class);
    }
}
