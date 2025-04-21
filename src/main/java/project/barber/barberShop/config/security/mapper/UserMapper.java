package project.barber.barberShop.config.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project.barber.barberShop.config.security.auth.controller.dto.RegisterUserDto;
import project.barber.barberShop.config.security.auth.model.UserEntity;
import project.barber.barberShop.domain.dto.RegisterClientDto;
import project.barber.barberShop.domain.model.ClientEntity;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    RegisterUserDto toDto(UserEntity entity);

    UserEntity toEntity(RegisterUserDto dto);
}
