package com.example;

import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;

import java.util.Arrays;

@TypeDef(type = DataType.INTEGER)
public enum GenUsuarioTipo {

    DEVELOPER(0),
    ADMINISTRATIVO(1),
    LIMITADO(2);

    private final Integer tipo;

    GenUsuarioTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static GenUsuarioTipo get(Integer tipo) {
        return Arrays.stream(values())
                .filter(v -> v.getTipo().equals(tipo))
                .findFirst()
                .orElse(null);
    }
}
