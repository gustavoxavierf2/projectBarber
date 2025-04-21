package project.barber.barberShop.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import project.barber.barberShop.controller.ClientApi;
import project.barber.barberShop.domain.dto.RegisterClientDto;
import project.barber.barberShop.service.ClientServiceFacede;

@RestController
@RequiredArgsConstructor
public class ClientApiImpl implements ClientApi {
    private final ClientServiceFacede faced;

    @Override
    public ResponseEntity<RegisterClientDto> registerClient(RegisterClientDto req) {
       return ResponseEntity.status(HttpStatus.CREATED).body(faced.registerClient(req));//TODO fazer um metodo defalt pra definir o statusCode
    }
}
