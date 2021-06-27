package com.carlos.filipe.controllerusercar.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "fipe")
public class Fipe {

    private String name;

    @OneToOne
    @JoinTable(name = "code",
            joinColumns = @JoinColumn(name = "code", foreignKey = @ForeignKey(name = "fk_code")),
            inverseJoinColumns = @JoinColumn(name = "fipe_code", foreignKey = @ForeignKey(name = "fk_fipe_code")))
    private String code;

    @NotNull
    @Column(name = "models", nullable = false)
    private List<Fipe> models;

    @NotNull
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCod(String code) {
        this.code = code;
    }

    public List<Fipe> getModels() {
        return models;
    }

    public void setModels(List<Fipe> models) {
        this.models = models;
    }
}
