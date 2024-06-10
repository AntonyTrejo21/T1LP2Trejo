package com.cibertec.TrejoT1.services;
import com.cibertec.TrejoT1.Model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ICarServices {
    List<Car> GetAllCars();
    Car SaveCar(Car entity);
    Car FindCarById(int id);
    List<Car> SearchCars(String name);
    Integer updateCar(Integer id, Car car);
    Integer deleteCar(Integer id);
}
