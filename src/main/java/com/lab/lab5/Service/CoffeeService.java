package com.lab.lab5.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lab.lab5.model.Coffee;
import com.lab.lab5.value_object.AddCoffeeRequest;
import com.lab.lab5.value_object.AddCoffeeRespose;
import com.lab.lab5.value_object.UpdateCoffeRequest;
import com.lab.lab5.value_object.UpdateCoffeeResponse;

@Service
public class CoffeeService {
    private List<Coffee> coffees = new ArrayList<>(Arrays.asList(
            new Coffee(1, "Espresso", 45),
            new Coffee(2, "Latte", 55)));

    public List<Coffee> getAll() {
        return coffees;
    }

    public Coffee getById(int id) {
        for (Coffee coffee : coffees) {
            if (id == coffee.getId()) {
                return coffee;
            }
        }
        return null;
    }

    public AddCoffeeRespose addCoffee(AddCoffeeRequest coffee) {
        int maxindex = coffees.size() + 1;

        coffees.add(new Coffee(maxindex, coffee.name(), coffee.price()));

        return new AddCoffeeRespose(coffees);
    }

    public UpdateCoffeeResponse updateCoffeeById(int id, UpdateCoffeRequest request) {
        for (Coffee item : coffees) {
            if (item.getId() == id) {
                item.setName(request.name());
                item.setPrice(request.price());
                break;
            }
        }
        return new UpdateCoffeeResponse(coffees);
    }

}
