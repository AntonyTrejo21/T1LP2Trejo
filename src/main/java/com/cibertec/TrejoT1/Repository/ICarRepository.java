package com.cibertec.TrejoT1.Repository;
import com.cibertec.TrejoT1.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends JpaRepository<Car, Integer>{
}
