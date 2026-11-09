package com.ApiEsquemaNuevo.api_esquema.services;

import java.util.List;

import com.ApiEsquemaNuevo.api_esquema.dtos.TitulacionRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.TitulacionResponseDto;

public interface TitulacionService {
      //Método para crear una titulacion.
    TitulacionResponseDto crear(TitulacionRequestDto datos);
    //Método que devuelve una lista de todas las titulaciones.
    List<TitulacionResponseDto> listar();
    //Método para buscar una titulacion por su ID.
    TitulacionResponseDto buscarPorId(Long id);
    //Método para buscar una titualcion por su código.
    TitulacionResponseDto buscarPorCodigo(String codigo);
    //Método para buscar una titulacion por su diminutivo.
    TitulacionResponseDto buscarPorDiminutivo(String diminutivo);
    //Método para actualizar un titulacion.
    TitulacionResponseDto actualizar(Long id, TitulacionRequestDto datos);
    //Método para eliminar una titulacion por su ID.
    void eliminarPorId(Long id);
    //Método para eliminar una titulacion por su código.
    void eliminarPorCodigo(String codigo);
    //Método para eliminar una titulacion por su código.
    void eliminarPorDiminutivo(String diminutivo);
}
