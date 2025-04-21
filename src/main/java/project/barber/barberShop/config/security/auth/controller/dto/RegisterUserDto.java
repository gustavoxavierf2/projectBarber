package project.barber.barberShop.config.security.auth.controller.dto;

import project.barber.barberShop.config.security.auth.model.UserTypeEnum;

import java.time.LocalDateTime;

public record RegisterUserDto(
        Long id,
        String name,
        String email,
        String userPassword,
        UserTypeEnum typeEnum,
        Boolean active,
        LocalDateTime creationTimestamp,
        LocalDateTime updateTimestamp
) {}
