package com.example;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;

import java.util.UUID;

@MappedEntity
public class GenUsuario {
    @Id
    private Long id;

    private GenUsuarioTipo tipo;

    public GenUsuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GenUsuarioTipo getTipo() {
        return tipo;
    }

    public void setTipo(GenUsuarioTipo tipo) {
        this.tipo = tipo;
    }
}
