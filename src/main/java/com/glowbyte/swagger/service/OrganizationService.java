package com.glowbyte.swagger.service;

import com.glowbyte.swagger.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final SecurityVisionClient securityVisionClient;

    public String create(OrganizationDto organizationDto) {
        return securityVisionClient.createOrganization(organizationDto, "QhzLSlW/8xUNIAq1f9wOdNMq0erGxATsoDQx7y6xlzRPPXRoLMVAZygXV4DYrX16892FvFxPKlcqJ35NyUKuDvKCcMKn4wMIZVnBoyNBtY6faaHVKzfSSa0eF3ojEu3jPsQUB1o68Dgja+ZS3OS+GuAvQZOKvYgBbVOhQLLRdW0=");
    }
}
