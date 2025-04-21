package project.barber.barberShop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.barber.barberShop.domain.dto.RegisterClientDto;
import project.barber.barberShop.service.clientService.RegisterClientUseCase;

@Service
@RequiredArgsConstructor
public class ClientServiceFacede {
    private final RegisterClientUseCase registerClientUseCase;

    public RegisterClientDto registerClient(RegisterClientDto req) {
        return registerClientUseCase.registerClient(req);
    }
}
