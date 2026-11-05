package com.ApiEsquemaNuevo.api_esquema.dtos;

public record ModuloResponseDto (
    Long idModulo,
    String codigo,
    String diminutivo,
    String nombre,
    String descripcion,
    Integer horasSemanales,
    Integer creditos
)
{}
