package com.ApiEsquemaNuevo.api_esquema.services;

import java.util.List;

import com.ApiEsquemaNuevo.api_esquema.dtos.FamiliaRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.FamiliaResponseDto;

public interface FamiliaService {
    FamiliaResponseDto crear(FamiliaRequestDto datos);
    List<FamiliaResponseDto> listar();
    FamiliaResponseDto buscarPorId(Long id);
    FamiliaResponseDto actualizar(Long id, FamiliaRequestDto datos);
    void eliminarPorId(Long id);
}
