package com.snapdrive.snapdrive.mapper.car;

import com.snapdrive.snapdrive.config.MapperConfig;
import com.snapdrive.snapdrive.dto.car.RequestCarDto;
import com.snapdrive.snapdrive.dto.car.RespondCarDto;
import com.snapdrive.snapdrive.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface CarMapper {
    Car toEntity(RequestCarDto carDto);

    RespondCarDto toDto(Car car);

    void updateCarFromDto(@MappingTarget Car car, RequestCarDto carDto);
}
