package com.lab.lab5.value_object;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UpdateCoffeRequest(
    @NotBlank(message = "Name can not be blank")
    String name,
    @Min(value = 0,message = "price cant be below 0")
    double price
) {
    
}
