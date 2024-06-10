package com.cibertec.TrejoT1.services.impl;
import com.cibertec.TrejoT1.Model.Car;
import com.cibertec.TrejoT1.Repository.ICarRepository;
import com.cibertec.TrejoT1.services.ICarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service

public class CarServices implements ICarServices {
    ICarRepository _carRepository;

    @Autowired
    public CarServices(ICarRepository carRepository) {
        _carRepository = carRepository;
    }


    @Override
    public List<Car> GetAllCars() {
        return _carRepository.findAll();
    }

    @Override
    public Car SaveCar(Car entity) {
        Car carSaved = _carRepository.save(entity);
        return carSaved;
    }

    @Override
    public Car FindCarById(int id) {
        Optional<Car> rowInDB = _carRepository.findById(id);
        if (rowInDB.isPresent())
            return rowInDB.get();
        else
            return new Car();
    }

    @Override
    public List<Car> SearchCars(String name) {
        return null;
    }

    @Override
    public Integer updateCar(Integer id, Car car) {
        Optional<Car> existingCar = _carRepository.findById(id);
        if (existingCar.isPresent()) {
            Car CarToUpdate = existingCar.get();
            CarToUpdate.setMarca(car.getMarca());
            CarToUpdate.setYear(car.getYear());
            CarToUpdate.setModelo(car.getModelo());
            _carRepository.save(CarToUpdate);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer deleteCar(Integer id) {
        Optional<Car> optionalCar = _carRepository.findById(id);

        if (optionalCar.isPresent()) {
            _carRepository.deleteById(id);
            return 1;
        } else {
            return 0;
        }
    }
}
