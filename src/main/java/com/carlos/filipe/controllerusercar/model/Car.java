package com.carlos.filipe.controllerusercar.model;

import com.carlos.filipe.controllerusercar.model.dto.CarDTO;
import com.carlos.filipe.controllerusercar.model.enums.FuelType;
import com.carlos.filipe.controllerusercar.model.enums.RotationDay;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @Column(name = "id")
    @Type(type = "Long")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false)
    @NotNull(message = "{car.brand.notNull}")
    private String brand;

    @Column(name = "model", nullable = false)
    @NotNull(message = "{car.model.notNull}")
    private String model;

    @Column(name = "year", nullable = false)
    @NotNull(message = "{car.year.notNull}")
    private String year;

    @Column(name = "fuel", nullable = false)
    @NotNull(message = "{car.fuel.notNull}")
    private FuelType fuel;

    @ManyToOne
    @JoinTable(name = "user_cars",
            joinColumns = @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "fk_car_id")),
            inverseJoinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id")))
    User user;

    @OneToOne
    @JoinTable(name = "fipe_Code",
            joinColumns = @JoinColumn(name = "fipe_code", foreignKey = @ForeignKey(name = "fk_fipe_code")),
            inverseJoinColumns = @JoinColumn(name = "code", foreignKey = @ForeignKey(name = "fk_code")))
    private String fipeCode;

    public Car(Long id, String brand, String model, String year, FuelType fuel, User user, String fipeCode) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.user = user;
        this.fipeCode = fipeCode;
    }

    public Car(CarDTO carDTO) {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
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

    public String rotationDay() {
        switch (Integer.parseInt(year)%10) {
            case 0:
                return RotationDay.MONDAY.getDescription();
            case 1:
                return RotationDay.MONDAY.getDescription();
            case 2:
                return RotationDay.TUESDAY.getDescription();
            case 3:
                return RotationDay.TUESDAY.getDescription();
            case 4:
                return RotationDay.WEDNESDAY.getDescription();
            case 5:
                return RotationDay.WEDNESDAY.getDescription();
            case 6:
                return RotationDay.THURSDAY.getDescription();
            case 7:
                return RotationDay.THURSDAY.getDescription();
            case 8:
                return RotationDay.FRIDAY.getDescription();
            case 9:
                return RotationDay.FRIDAY.getDescription();
            default: throw new IllegalArgumentException("Este não é um dia valido");
        }
    }
}
