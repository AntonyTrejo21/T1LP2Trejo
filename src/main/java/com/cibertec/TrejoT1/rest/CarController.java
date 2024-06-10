package com.cibertec.TrejoT1.rest;
import com.cibertec.TrejoT1.Model.Car;
import com.cibertec.TrejoT1.services.ICarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CarController {
    ICarServices carServices;

    @Autowired
    public CarController(ICarServices carServices) {
        this.carServices=carServices;
    }

    @GetMapping("/cars")
    public List<Car> getAll() {
        return carServices.GetAllCars();
    }

    @GetMapping("/car/{id}")
    public Car getAll(@PathVariable int id) {
        return carServices.FindCarById(id);
    }

    @PostMapping("/car")
    public Car saveCar(@RequestBody Car entity) {
        return carServices.SaveCar(entity);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Integer> updateCar(@PathVariable Integer id, @RequestBody Car car) {
        Integer updated = carServices.updateCar(id, car);
        if (updated == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Integer> deleteCar(@PathVariable Integer id) {
        Integer deleted = carServices.deleteCar(id);
        if (deleted == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
