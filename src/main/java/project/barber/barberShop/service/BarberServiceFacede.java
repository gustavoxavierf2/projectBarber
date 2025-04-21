package project.barber.barberShop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.barber.barberShop.config.exceptions.GenericValidationException;
import project.barber.barberShop.domain.dto.RegisterBarberShopDto;
import project.barber.barberShop.service.barberService.RegisterBarberUseCase;

@Service
@RequiredArgsConstructor
public class BarberServiceFacede {
    private final RegisterBarberUseCase registerBarberUseCase;

    public RegisterBarberShopDto registerBarber(RegisterBarberShopDto req) throws GenericValidationException {
        return registerBarberUseCase.registerBarber(req);
    }
}
