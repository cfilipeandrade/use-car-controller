package com.carlos.filipe.controllerusercar.model.enums;

public enum FuelType {

    ETHANOL("Etanol"),
    GAS("Gasolina"),
    DIESEL("Diesel");

    private final String description;

    FuelType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

}
