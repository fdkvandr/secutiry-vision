package com.glowbyte.swagger.controller;

import com.glowbyte.swagger.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.stream.Collectors;

@RequestMapping("/api/**")
@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping
    public ResponseEntity<?> getMethod(HttpServletRequest httpServletRequest) {
        String parameters = getParameters(httpServletRequest);
        String servletPath = httpServletRequest.getServletPath();
        return mainService.getMethod(servletPath + parameters);
    }

    @PostMapping
    public ResponseEntity<?> postMethod(HttpServletRequest httpServletRequest) throws IOException {
        String parameters = getParameters(httpServletRequest);
        String servletPath = httpServletRequest.getServletPath();
        String request = httpServletRequest.getReader().lines().collect(Collectors.joining());
        return mainService.postMethod(servletPath + parameters, request);
    }

    private String getParameters(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getParameterMap()
                .entrySet()
                .stream()
                .map(it -> "?" + it.getKey() + "=" + it.getValue()[0])
                .collect(Collectors.joining());
    }
}
