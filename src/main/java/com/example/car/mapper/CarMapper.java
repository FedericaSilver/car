package com.example.car.mapper;

import com.example.car.entity.Car;
import com.example.car.model.dto.CarDTO;
import com.example.car.model.dto.NewCarDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
builder = @Builder(disableBuilder = true))
public interface CarMapper {
    CarDTO toCarDTO(Car car);
    Car toCar(NewCarDTO newCarDTO);
}
