package project.barber.barberShop.service.clientService.useCaseImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.barber.barberShop.domain.dto.RegisterClientDto;
import project.barber.barberShop.mapper.ClientMapper;
import project.barber.barberShop.repository.ClientRepository;
import project.barber.barberShop.service.clientService.RegisterClientUseCase;

@Service
@RequiredArgsConstructor
public class RegisterClientUseCaseImpl implements RegisterClientUseCase {
    private final ClientRepository clientRepository;

    @Override
    public RegisterClientDto registerClient(RegisterClientDto req) {
        var client = ClientMapper.INSTANCE.toEntity(req);

        return ClientMapper.INSTANCE.toDto(clientRepository.save(client));
    }
}
