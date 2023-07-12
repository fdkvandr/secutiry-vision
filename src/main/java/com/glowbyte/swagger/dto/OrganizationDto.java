package com.glowbyte.swagger.dto;

import java.util.List;

public record OrganizationDto(

        Reference reference,
        List<Properties> properties) {

    public record Reference(
            int id,
            String name) {}

    public record Properties(
            String name,
            String value) {
    }
}
