package com.carlos.filipe.controllerusercar.model.enums;

public enum TypeVehicle {
    CAR("Carro"),
    TRUCK("Caminhão");

    private final String description;

    TypeVehicle(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TypeVehicle{" +
                "description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }
}
