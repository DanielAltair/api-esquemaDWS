package com.ApiEsquemaNuevo.api_esquema.services;

import java.util.List;

import com.ApiEsquemaNuevo.api_esquema.dtos.EstadoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.EstadoResponseDto;

public interface EstadoService {
      //Método para crear un estado.
    EstadoResponseDto crear(EstadoRequestDto datos);
    //Método que devuelve una lista de todos los estados.
    List<EstadoResponseDto> listar();
    //Método para buscar un estado por su ID.
    EstadoResponseDto buscarPorId(Long id);
    //Método para buscar un estado por su código.
    EstadoResponseDto actualizar(Long id, EstadoRequestDto datos);
    //Método para eliminar un estado por su ID.
    void eliminarPorId(Long id);
}

