package project.barber.barberShop.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import project.barber.barberShop.config.exceptions.GenericValidationException;
import project.barber.barberShop.controller.BarbeariaApi;
import project.barber.barberShop.domain.dto.RegisterBarberShopDto;
import project.barber.barberShop.service.BarberServiceFacede;

@RestController
@RequiredArgsConstructor
public class BarberApiImpl implements BarbeariaApi {
    private final BarberServiceFacede faced;

    @Override
    public ResponseEntity<RegisterBarberShopDto> registerBarber(RegisterBarberShopDto req) throws GenericValidationException {
        return ResponseEntity.status(HttpStatus.CREATED).body(faced.registerBarber(req));
    }
}
