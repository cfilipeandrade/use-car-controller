package com.carlos.filipe.controllerusercar.repository;

import com.carlos.filipe.controllerusercar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findById(Long id);

    @Query("SELECT c FROM Car c " +
            "WHERE c.userId = :idParam")
    List<Car> findByUserId(@Param("idParam") Long userId);
}
