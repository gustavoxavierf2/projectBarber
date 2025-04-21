package project.barber.barberShop.service.clientService;

import project.barber.barberShop.domain.dto.RegisterClientDto;

public interface RegisterClientUseCase {

    RegisterClientDto registerClient(RegisterClientDto req);
}
