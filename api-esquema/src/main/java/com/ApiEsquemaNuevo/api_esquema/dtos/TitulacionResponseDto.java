package com.ApiEsquemaNuevo.api_esquema.dtos;

public record  TitulacionResponseDto (
    Long idTitulacion,
    String codigo,
    String diminutivo,
    double horasTotales
)
{}
