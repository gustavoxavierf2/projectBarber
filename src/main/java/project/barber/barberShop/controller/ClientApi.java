package project.barber.barberShop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.barber.barberShop.domain.dto.RegisterClientDto;


@RequestMapping("/client")
public interface ClientApi {

    @PostMapping
    ResponseEntity<RegisterClientDto> registerClient(@RequestBody RegisterClientDto req);
}
