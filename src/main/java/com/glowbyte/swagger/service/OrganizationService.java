package com.glowbyte.swagger.service;

import com.glowbyte.swagger.dto.OrganizationDto;
import com.glowbyte.swagger.service.client.SecurityVisionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final SecurityVisionClient securityVisionClient;

    public String create(OrganizationDto organizationDto) {
        return securityVisionClient.createOrganization(organizationDto);
    }
}
