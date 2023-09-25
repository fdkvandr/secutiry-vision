package com.glowbyte.swagger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MainService {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${sv-param.default-url}")
    private final String defaultUrl;
    private final HttpHeaders defaultHttpHeaders;

    public ResponseEntity<?> getMethod(String path) {
        HttpEntity<Void> entity = new HttpEntity<>(defaultHttpHeaders);
        return restTemplate.exchange(defaultUrl + path, HttpMethod.GET, entity, String.class);
    }

    public ResponseEntity<?> postMethod(String path, String request) {
        HttpEntity<String> entity = new HttpEntity<>(request, defaultHttpHeaders);
        return restTemplate.exchange(defaultUrl + path, HttpMethod.POST, entity, String.class);
    }
}
