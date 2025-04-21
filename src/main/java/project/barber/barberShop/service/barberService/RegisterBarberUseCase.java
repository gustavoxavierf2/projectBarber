package project.barber.barberShop.service.barberService;

import project.barber.barberShop.config.exceptions.GenericValidationException;
import project.barber.barberShop.domain.dto.RegisterBarberShopDto;


public interface RegisterBarberUseCase {
    RegisterBarberShopDto registerBarber(RegisterBarberShopDto req) throws GenericValidationException;
}
