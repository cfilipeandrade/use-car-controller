package com.carlos.filipe.controllerusercar.model.enums;

public enum RotationDay {
    MONDAY("Segunda-feira"),
    TUESDAY("Terça-feira"),
    WEDNESDAY("Quarta-feira"),
    THURSDAY("Quinta-feira"),
    FRIDAY("Sexta-feira"),
    SATURDAY("Sábado"),
    SUNDAY("Domingo");

    private final String description;

    RotationDay(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RotationDay{" +
                "description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }
}
