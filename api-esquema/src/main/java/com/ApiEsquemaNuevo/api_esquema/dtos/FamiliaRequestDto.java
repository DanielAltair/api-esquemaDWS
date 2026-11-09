package com.ApiEsquemaNuevo.api_esquema.dtos;

public record FamiliaRequestDto(

    String nombrePadre,
    String apellidosPadre,
    String emailPadre,
    String telefonoPadre,
    String direccionPadre,
    Integer cpPadre,
    String provinciaPadre,
    String nombreMadre,
    String apellidosMadre,
    String emailMadre,
    String telefonoMadre,
    String direccionMadre,
    Integer cpMadre,
    String provinciaMadre,
    boolean sonSeparados,
    boolean esCompartida,
    boolean esPadre,
    boolean esMadre
) 
{}
