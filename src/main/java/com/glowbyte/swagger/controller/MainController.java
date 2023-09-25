package com.glowbyte.swagger.controller;

import com.glowbyte.swagger.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.stream.Collectors;

@RequestMapping("/api/**")
@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping
    public ResponseEntity<?> getMethod(HttpServletRequest httpServletRequest, @RequestHeader(name = "sv-token") String token) {
        String parameters = getParameters(httpServletRequest);
        String servletPath = httpServletRequest.getServletPath();
        return mainService.getMethod(servletPath + parameters, token);
    }

    @PostMapping
    public ResponseEntity<?> postMethod(HttpServletRequest httpServletRequest, @RequestHeader(name = "sv-token") String token) throws IOException {
        String parameters = getParameters(httpServletRequest);
        String servletPath = httpServletRequest.getServletPath();
        String request = httpServletRequest.getReader().lines().collect(Collectors.joining());
        return mainService.postMethod(servletPath + parameters, request, token);
    }

    private String getParameters(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getParameterMap()
                .entrySet()
                .stream()
                .map(it -> "?" + it.getKey() + "=" + it.getValue()[0])
                .collect(Collectors.joining());
    }
}
