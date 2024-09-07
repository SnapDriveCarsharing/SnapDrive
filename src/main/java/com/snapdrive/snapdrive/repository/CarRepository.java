package com.snapdrive.snapdrive.repository;

import com.snapdrive.snapdrive.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
