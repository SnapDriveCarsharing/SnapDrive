package com.snapdrive.snapdrive.dto.car;

import com.snapdrive.snapdrive.model.Car;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class RequestCarDto {
    @NotBlank
    private String model;
    @NotBlank
    private String brand;
    @NotBlank
    private Car.Type type;
    @Min(0)
    private int inventory;
    @Min(0)
    private BigDecimal dailyFee;
}
