package com.glowbyte.swagger.controller;

import com.glowbyte.swagger.dto.OrganizationDto;
import com.glowbyte.swagger.service.OrganizationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@Tag(name = "Организация", description = "API работы с организацией")
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping(value = "/reference/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody OrganizationDto organizationDto) {
        return organizationService.create(organizationDto);
    }
}
