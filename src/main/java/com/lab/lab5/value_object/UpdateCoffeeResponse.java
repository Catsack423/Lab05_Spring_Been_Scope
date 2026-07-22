package com.lab.lab5.value_object;

import java.util.List;

import com.lab.lab5.model.Coffee;

public record UpdateCoffeeResponse(List<Coffee> coffees) {

}
