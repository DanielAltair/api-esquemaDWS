package com.ApiEsquemaNuevo.api_esquema.dtos;

public record DepartamentoResponseDto(
    Long idDepartamento,
    String codigo,
    String nombre,
    String descripcion,
    String telefono
) {}
