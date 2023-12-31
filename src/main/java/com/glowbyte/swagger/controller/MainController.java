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
    public ResponseEntity<String> getMethod(HttpServletRequest httpServletRequest, @RequestHeader(name = "sv-token") String token) {
        String pathWithParameters = getPathWithParameters(httpServletRequest);
        return mainService.getMethod(pathWithParameters, token);
    }

    @PostMapping
    public ResponseEntity<String> postMethod(HttpServletRequest httpServletRequest, @RequestHeader(name = "sv-token") String token) throws IOException {
        String pathWithParameters = getPathWithParameters(httpServletRequest);
        String request = httpServletRequest.getReader().lines().collect(Collectors.joining());
        return mainService.postMethod(pathWithParameters, request, token);
    }

    private String getPathWithParameters(HttpServletRequest httpServletRequest) {
        String path = httpServletRequest.getServletPath();
        String parameters = httpServletRequest.getQueryString();
        return parameters == null ? path : path.concat("?").concat(parameters);
    }
}
