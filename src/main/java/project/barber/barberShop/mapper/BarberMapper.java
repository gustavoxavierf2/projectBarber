package project.barber.barberShop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project.barber.barberShop.domain.dto.RegisterBarberShopDto;
import project.barber.barberShop.domain.dto.RegisterClientDto;
import project.barber.barberShop.domain.model.BarberEntity;
import project.barber.barberShop.domain.model.ClientEntity;

@Mapper
public interface BarberMapper {
    BarberMapper INSTANCE = Mappers.getMapper(BarberMapper.class);

    RegisterBarberShopDto toDto(BarberEntity entity);

    BarberEntity toEntity(RegisterBarberShopDto dto);
}
