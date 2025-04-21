package project.barber.barberShop.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

public record RegisterClientDto(
        Long id,
        Long userId,
        String phone,
        String latitude,
        String longitude,
        LocalDate birthDate,
        String notes
) {}

