package com.carlos.filipe.controllerusercar.model.dto;

import com.carlos.filipe.controllerusercar.model.Car;
import com.carlos.filipe.controllerusercar.model.User;
import com.carlos.filipe.controllerusercar.model.enums.FuelType;
import com.carlos.filipe.controllerusercar.repository.CarRepository;

import javax.validation.constraints.NotNull;

public class CarDTO {

    private CarRepository repository;

    private Long id;

    @NotNull(message = "{carDTO.brand.notNull}")
    private String brand;

    @NotNull(message = "{carDTO.model.notNull}")
    private String model;

    @NotNull(message = "{carDTO.year.notNull}")
    private String year;

    @NotNull(message = "{carDTO.fuel.notNull}")
    private FuelType fuel;

    private User user;

    @NotNull(message = "{carDTO.fipecode.notNull}")
    private String fipeCode;

    private String rotationDay;

    private Boolean rotation;

    public CarDTO(Long id, String brand, String model, String year, FuelType fuel, User user, String fipeCode) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.user = user;
        this.fipeCode = fipeCode;
    }

    public CarDTO(Car car) {
        repository.save(car);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public FuelType getFuel() {
        return fuel;
    }

    public void setFuel(FuelType fuel) {
        this.fuel = fuel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFipeCode() {
        return fipeCode;
    }

    public void setFipeCode(String fipeCode) {
        this.fipeCode = fipeCode;
    }

    public String getRotationDay() {
        return rotationDay;
    }

    public void setRotationDay(String rotationDay) {
        this.rotationDay = rotationDay;
    }

    public Boolean getRotation() {
        return rotation;
    }

    public void setRotation(Boolean rotation) {
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuel=" + fuel +
                ", user=" + user +
                ", fipeCode='" + fipeCode + '\'' +
                '}';
    }
}
