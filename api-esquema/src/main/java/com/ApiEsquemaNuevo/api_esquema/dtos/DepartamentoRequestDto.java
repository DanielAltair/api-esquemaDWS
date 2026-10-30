package com.ApiEsquemaNuevo.api_esquema.dtos;

public record DepartamentoRequestDto (
    String codigo,
    String nombre,
    String descripcion,
    String telefono
) {}
