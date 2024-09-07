package com.snapdrive.snapdrive.dto.car;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCarInventoryDto {
    @NotBlank
    @Min(0)
    private int inventory;
}
