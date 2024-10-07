package com.example.car.service;

import ch.qos.logback.core.subst.Token;
import com.example.car.entity.Car;
import com.example.car.mapper.CarMapper;
import com.example.car.model.Type;
import com.example.car.model.dto.CarDTO;
import com.example.car.model.dto.NewCarDTO;
import com.example.car.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarDTO addNewCar(NewCarDTO newCarDTO) {
        Car newCar= carMapper.toCar(newCarDTO);
        carRepository.save(newCar);
        return carMapper.toCarDTO(newCar);
    }

    public CarDTO getCarById(Long carId) {
        Car carFound = carRepository.findById(carId).orElseThrow(()-> new NoSuchElementException("Car with id " + carId + " doesn't exist"));
        return carMapper.toCarDTO(carFound);
    }

    public List<CarDTO> getAllCars() {
         List<Car> allCars = carRepository.findAll();
        return allCars.stream().map(c-> carMapper.toCarDTO(c)).toList();
    }

    public CarDTO updateType(Long carId, String type) {
        Car carToUpdate = carRepository.findById(carId).orElseThrow(()-> new NoSuchElementException("Impossible to update car with id " + carId + ". It doesn't exist."));
        carToUpdate.setType(Type.valueOf(type));
        carRepository.save(carToUpdate);
        return carMapper.toCarDTO(carToUpdate);
    }

    public boolean deleteCarById(Long carId) throws NoSuchElementException {
        if(carRepository.existsById(carId)){
            carRepository.deleteById(carId);
            return true;
        }else {
            throw new NoSuchElementException("Impossible to delete car with id " + carId + ". It doesn't exist");
        }

    }

    public boolean deleteAllCars() {
        carRepository.deleteAll();
        return true;
    }

}
