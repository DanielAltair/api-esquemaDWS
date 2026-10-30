package com.ApiEsquemaNuevo.api_esquema.services;



import java.util.List;

import com.ApiEsquemaNuevo.api_esquema.dtos.DepartamentoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.DepartamentoResponseDto;

public interface DepartamentoService {
    //Método para crear un departamento.
    DepartamentoResponseDto crear(DepartamentoRequestDto datos);
    //Método que devuelve una lista de todos los departamentos.
    List<DepartamentoResponseDto> listar();
    //Método para buscar un departamento por su ID.
    DepartamentoResponseDto buscarPorId(Long id);
    //Método para buscar un departamento por su código.
    DepartamentoResponseDto buscarPorCodigo(String codigo);
    //Método para actualizar un departamento.
    DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto datos);
    //Método para eliminar un departamento.
    void eliminar(Long id);
}
