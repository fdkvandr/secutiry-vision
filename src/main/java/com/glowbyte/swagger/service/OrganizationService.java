package com.glowbyte.swagger.service;

import com.glowbyte.swagger.dto.OrganisationResponseDto;
import com.glowbyte.swagger.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final SecurityVisionClient securityVisionClient;

    public OrganisationResponseDto create(OrganizationDto organizationDto) {
        return securityVisionClient.createOrganization(organizationDto);
    }
}
