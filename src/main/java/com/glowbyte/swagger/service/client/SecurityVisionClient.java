package com.glowbyte.swagger.service.client;

import com.glowbyte.swagger.dto.OrganizationDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("${sv-param.default-url}")
public interface SecurityVisionClient {

    @PostExchange("/create")
    String createOrganization(@RequestBody OrganizationDto organizationDto);
}
