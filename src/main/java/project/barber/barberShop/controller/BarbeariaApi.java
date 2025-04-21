package project.barber.barberShop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.barber.barberShop.config.exceptions.GenericValidationException;
import project.barber.barberShop.domain.dto.RegisterBarberShopDto;

@RequestMapping("/barber")
public interface BarbeariaApi {

    @PostMapping
    ResponseEntity<RegisterBarberShopDto> registerBarber(@RequestBody RegisterBarberShopDto req) throws GenericValidationException;
}
