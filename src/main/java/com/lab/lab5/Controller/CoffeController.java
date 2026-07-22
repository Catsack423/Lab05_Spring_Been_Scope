package com.lab.lab5.Controller;

import com.lab.lab5.model.*;
import com.lab.lab5.value_object.AddCoffeeRequest;
import com.lab.lab5.value_object.AddCoffeeRespose;
import com.lab.lab5.value_object.UpdateCoffeRequest;
import com.lab.lab5.value_object.UpdateCoffeeResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RestController;

import com.lab.lab5.Service.CoffeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CoffeController {
    private final CoffeeService coffee;

    public CoffeController(CoffeeService coffee) {
        this.coffee = coffee;
    }

    @GetMapping("/coffees")
    public ResponseEntity<List<Coffee>> getAllCoffe() {
        var res = coffee.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffeebyId(@PathVariable int id) {
        var res = coffee.getById(id);

        if (res == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(res);
    }

    @PostMapping("/coffees")
    public ResponseEntity<AddCoffeeRespose> addCoffee(@Valid @RequestBody AddCoffeeRequest request) {
        var res = coffee.addCoffee(request);
        return ResponseEntity.ok(res);
    };

    @PutMapping("/coffees/{id}")
    public ResponseEntity<UpdateCoffeeResponse> updateCoffee(@Min(1) @PathVariable int id ,@Valid @RequestBody UpdateCoffeRequest reqest){
        var res = coffee.updateCoffeeById(id, reqest);
        return ResponseEntity.ok(res);
    }

}
