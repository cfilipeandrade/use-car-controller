package com.carlos.filipe.controllerusercar.model.dto;

import com.carlos.filipe.controllerusercar.model.Car;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO {

    private Long id;

    @NotNull(message = "{useDTO.cpf.notNull}")
    private String cpf;

    @NotNull(message = "{userDTO.name.notNull}")
    private String name;

    @NotNull(message = "{useDTO.email.notNull}")
    private String email;

    @NotNull(message = "{useDTO.name.notNull}")
    private LocalDateTime dateBorn;

    private Set<Car> cars = new HashSet<>();

    public UserDTO(Long id, String cpf, String name, String email, LocalDateTime dateBorn, Set<Car> cars) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.dateBorn = dateBorn;
        this.cars = cars;
    }

    public UserDTO(Object user) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(LocalDateTime dateBorn) {
        this.dateBorn = dateBorn;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateBorn=" + dateBorn +
                ", cars=" + cars +
                '}';
    }

    public void setCars(List<CarDTO> carDTO) {
        this.cars = cars;
    }
}
