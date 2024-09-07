package com.snapdrive.snapdrive.service;

import com.snapdrive.snapdrive.dto.car.RequestCarDto;
import com.snapdrive.snapdrive.dto.car.RequestCarInventoryDto;
import com.snapdrive.snapdrive.dto.car.RespondCarDto;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CarService {
    RespondCarDto createCar(RequestCarDto requestDto);

    List<RespondCarDto> getAll(Pageable pageable);

    void deleteById(Long id);

    RespondCarDto updateCar(Long id, RequestCarDto requestDto);

    RespondCarDto updateCar(Long id, RequestCarInventoryDto requestDto);
}
