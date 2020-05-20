package com.example;

import io.micronaut.context.annotation.Factory;
import io.micronaut.core.convert.TypeConverter;

import javax.inject.Singleton;
import java.util.Optional;

@Factory
public class GenUsuarioTipoConverter {

    @Singleton
    public TypeConverter<GenUsuarioTipo, Integer> genUsuarioTipoIntTypeConverter() {
        return (tipo, targetType, context) -> Optional.of(tipo.getTipo());
    }

    @Singleton
    public TypeConverter<Integer, GenUsuarioTipo> intGenUsuarioTipoIntTypeConverter() {
        return (object, targetType, context) -> Optional.ofNullable(GenUsuarioTipo.get(object));
    }
}
