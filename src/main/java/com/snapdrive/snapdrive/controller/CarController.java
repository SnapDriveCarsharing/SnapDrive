package com.snapdrive.snapdrive.controller;

import com.snapdrive.snapdrive.dto.car.RequestCarDto;
import com.snapdrive.snapdrive.dto.car.RequestCarInventoryDto;
import com.snapdrive.snapdrive.dto.car.RespondCarDto;
import com.snapdrive.snapdrive.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/cars"))
@RequiredArgsConstructor
@Validated
public class CarController {
    private final CarService carService;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @Operation(summary = "Create a new car", description = "Add new car to DB")
    public RespondCarDto createCar(@RequestBody @Valid RequestCarDto requestDto) {
        return carService.createCar(requestDto);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    @Operation(summary = "Get all cars", description = "Get list of all cars in the DB")
    public List<RespondCarDto> getAllCars(@ParameterObject @PageableDefault Pageable pageable) {
        return carService.getAll(pageable);
    }

    //    GET: /cars/ - get car's detailed information


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    @Operation(summary = "Update car information",
            description = "Update all information about car with id")
    public RespondCarDto updateCar(@PathVariable @Positive Long id,
                              @RequestBody @Valid RequestCarDto requestDto) {
        return carService.updateCar(id, requestDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    @Operation(summary = "Update car information",
            description = "Update inventory information about car")
    public RespondCarDto updateCarInventory(@PathVariable @Positive Long id,
                              @RequestBody @Valid RequestCarInventoryDto requestDto) {
        return carService.updateCar(id, requestDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete car by ID",
            description = "Delete existing in DB car by id, soft delete(leave data about car in DB)")
    public void deleteCar(@PathVariable @Positive Long id) {
        carService.deleteById(id);
    }
}
