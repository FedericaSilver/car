package com.example.car.controller;

import com.example.car.model.dto.CarDTO;
import com.example.car.model.dto.NewCarDTO;
import com.example.car.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping()
    public ResponseEntity<CarDTO> addNewCar(@RequestBody NewCarDTO newCarDTO){
        return ResponseEntity.ok(carService.addNewCar(newCarDTO));
    }

    @GetMapping("/{carId}")
    public ResponseEntity<?> getCarById(@PathVariable ("carId") Long carId){
        try{
            return ResponseEntity.ok(carService.getCarById(carId));
        } catch (NoSuchElementException e){
            log.error("Error in get a car by Id {} : {}", carId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars(){
         return ResponseEntity.ok(carService.getAllCars());
    }

    @PatchMapping("/{carId}")
    public ResponseEntity<?> updateType(@PathVariable ("carId") Long carId, @RequestParam (name = "type") String type){
        try{
            return ResponseEntity.ok(carService.updateType(carId, type));
        }catch (NoSuchElementException e){
            log.error("Error to update a car by Id {} : {}", carId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<?> deleteCarById(@PathVariable ("carId") Long carId){
        try{
            return ResponseEntity.ok(carService.deleteCarById(carId));
        } catch (NoSuchElementException e){
            log.error("Error to delete car by Id {} : {}", carId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deleteAllCars(){
        return ResponseEntity.ok(carService.deleteAllCars());
    }


}
