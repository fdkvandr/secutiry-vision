package com.glowbyte.swagger.controller;

import com.glowbyte.swagger.dto.OrganisationResponseDto;
import com.glowbyte.swagger.dto.OrganizationDto;
import com.glowbyte.swagger.service.OrganizationService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "400", description = "Валидация не пройдена"),
            @ApiResponse(responseCode = "401", description = "Пользователь не авторизован"),
            @ApiResponse(responseCode = "403", description = "Доступ запрещён"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервиса"),
    })
    @PostMapping("/reference/create")
    public OrganisationResponseDto create(@RequestBody OrganizationDto organizationDto) {
        return organizationService.create(organizationDto);
    }
}
