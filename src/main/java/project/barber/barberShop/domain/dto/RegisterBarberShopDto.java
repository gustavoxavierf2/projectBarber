package project.barber.barberShop.domain.dto;

import project.barber.barberShop.config.security.auth.model.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterBarberShopDto(
        Long id,
        UserEntity userId,
        String fantasyName,
        String address,
        String complement,
        String city,
        String state,
        String postalCode,
        String latitude,
        String longitude,
        String phone,
        String mobile,
        String coverPhoto,
        String instagram,
        String description,
        String openingHours,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
