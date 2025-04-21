package project.barber.barberShop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project.barber.barberShop.domain.dto.RegisterClientDto;
import project.barber.barberShop.domain.model.ClientEntity;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    RegisterClientDto toDto(ClientEntity entity);

    ClientEntity toEntity(RegisterClientDto dto);
}
