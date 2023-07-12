package com.glowbyte.swagger.service;

import com.glowbyte.swagger.dto.OrganizationDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface SecurityVisionClient {

    @PostExchange("https://158.160.23.243:8080/api/reference/create")
    String createOrganization(@RequestBody OrganizationDto organizationDto);
}
