package com.glowbyte.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class OpenApiController {

    @GetMapping("/api-docs")
    public String get() throws IOException {
        return new String(Files.readAllBytes(Paths.get("./openapi.json")));
    }
}
