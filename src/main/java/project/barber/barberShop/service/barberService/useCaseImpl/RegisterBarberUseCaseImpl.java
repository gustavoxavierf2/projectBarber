package project.barber.barberShop.service.barberService.useCaseImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.barber.barberShop.config.exceptions.GenericValidationException;
import project.barber.barberShop.config.security.auth.model.UserEntity;
import project.barber.barberShop.config.security.auth.repository.UserRepository;
import project.barber.barberShop.domain.dto.RegisterBarberShopDto;
import project.barber.barberShop.mapper.BarberMapper;
import project.barber.barberShop.repository.BarberRepository;
import project.barber.barberShop.service.barberService.RegisterBarberUseCase;

@Service
@RequiredArgsConstructor
public class RegisterBarberUseCaseImpl implements RegisterBarberUseCase {
    private final BarberRepository barberRepository;
    private final UserRepository userRepository;

    @Override
    public RegisterBarberShopDto registerBarber(RegisterBarberShopDto req) throws GenericValidationException {
        UserEntity user = userRepository.findById(req.userId().getId())
                .orElseThrow(() -> new GenericValidationException("Usuario não encontrado", HttpStatus.NOT_FOUND));

        var barber = BarberMapper.INSTANCE.toEntity(req);
        barber.setUserId(user);

        return BarberMapper.INSTANCE.toDto(barberRepository.save(barber));
    }
}
