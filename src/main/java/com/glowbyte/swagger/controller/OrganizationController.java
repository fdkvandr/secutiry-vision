package com.glowbyte.swagger.controller;

import com.glowbyte.swagger.dto.OrganizationDto;
import com.glowbyte.swagger.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping("/reference/create")
    public String create(@RequestBody OrganizationDto organizationDto) {
        System.out.println(organizationDto.reference.name);
        return organizationService.create(organizationDto);
    }
}
