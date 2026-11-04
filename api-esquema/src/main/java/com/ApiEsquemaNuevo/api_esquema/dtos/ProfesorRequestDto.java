package com.ApiEsquemaNuevo.api_esquema.dtos;

public record  ProfesorRequestDto(
    String dni,
    String nombre,
    String apellidos,
    String emailCentro,
    String emailPersonal,
    String telefonoPersonal,
    Long idDepartamento
) {}