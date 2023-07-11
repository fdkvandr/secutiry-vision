package com.glowbyte.swagger.dto;

import java.util.List;

public class OrganizationDto {
    public OrganizationDto(Reference reference, List<Properties> properties) {
        this.reference = reference;
        this.properties = properties;
    }

    public OrganizationDto() {
    }

    public Reference reference;
    public List<Properties> properties;

    public static class Reference {
        public Reference(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public Reference() {
        }

        public int id;
        public String name;
    }

    public static class Properties {
        public String name;
        public String value;

        public Properties(String name, String value) {
            this.name = name;
            this.value = value;
        }
        public Properties() {
        }
    }
}
