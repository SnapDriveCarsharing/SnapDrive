package com.snapdrive.snapdrive.service.impl;

import com.snapdrive.snapdrive.dto.car.RequestCarDto;
import com.snapdrive.snapdrive.dto.car.RequestCarInventoryDto;
import com.snapdrive.snapdrive.dto.car.RespondCarDto;
import com.snapdrive.snapdrive.exception.EntityNotFoundException;
import com.snapdrive.snapdrive.mapper.car.CarMapper;
import com.snapdrive.snapdrive.model.Car;
import com.snapdrive.snapdrive.repository.CarRepository;
import com.snapdrive.snapdrive.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public RespondCarDto createCar(RequestCarDto requestDto) {
        Car car = carMapper.toEntity(requestDto);
        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public List<RespondCarDto> getAll(Pageable pageable) {
        return carRepository.findAll(pageable)
                .stream()
                .map(carMapper::toDto)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        findCarById(id);
        carRepository.deleteById(id);
    }

    @Override
    public RespondCarDto updateCar(Long id, RequestCarDto requestDto) {
        Car car = findCarById(id);
        carMapper.updateCarFromDto(car, requestDto);
        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public RespondCarDto updateCar(Long id, RequestCarInventoryDto requestDto) {
        Car car = findCarById(id);
        car.setInventory(requestDto.getInventory());
        return carMapper.toDto(carRepository.save(car));
    }

    private Car findCarById(Long id) {
        return carRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Car with id " + id + " is not found")
        );
    }
}
