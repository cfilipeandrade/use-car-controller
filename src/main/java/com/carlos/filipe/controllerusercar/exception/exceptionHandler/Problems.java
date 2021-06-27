package com.carlos.filipe.controllerusercar.exception.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problems {
    private Integer status;
    private OffsetDateTime dateTime;
    private String label;
    private List<Field> fields;

    public static class Field {
        private String name;
        private String mensage;

        public Field(String name, String mensage) {
            super();
            this.name = name;
            this.mensage = mensage;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMensage() {
            return mensage;
        }

        public void setMensage(String mensage) {
            this.mensage = mensage;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLabel(String message) {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
