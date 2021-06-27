package com.carlos.filipe.controllerusercar.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_user_cpf", columnNames = "cpf")})
public class User {

    @Id
    @Column(name = "id")
    @Type(type = "Long")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CPF
    @Column(name = "cpf", unique = true)
    @NotNull(message = "{use.cpf.notNull}")
    String cpf;

    @Column(name = "name", nullable = false)
    @NotNull(message = "{use.name.notNull}")
    String name;

    @Column(name = "email", nullable = false)
    @NotNull(message = "{use.email.notNull}")
    String email;

    @Column(name = "dateBorn", nullable = false)
    @NotNull(message = "{use.name.notNull}")
    LocalDateTime dateBorn;

    @OneToMany
    @JoinTable(name = "user_cars",
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id")),
            inverseJoinColumns = @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "fk_car_id")))
    Set<Car> cars = new HashSet<>();

    public User(String name, String cpf, String email, LocalDateTime dateBorn, Set<Car> cars) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.dateBorn = dateBorn;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
