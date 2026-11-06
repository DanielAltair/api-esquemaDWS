package com.ApiEsquemaNuevo.api_esquema.services;

import java.util.List;

import com.ApiEsquemaNuevo.api_esquema.dtos.CursoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.CursoResponseDto;

public interface CursoService {

    //Método para crear un curso.
    CursoResponseDto crear(CursoRequestDto datos);
    //Método que devuelve una lista de todos los cursos.
    List<CursoResponseDto> listar();
    //Método para buscar un curso por su ID.
    CursoResponseDto buscarPorID(Long id);
    //Método para buscar un curso por su diminutivo.
    CursoResponseDto buscarPorDiminutivo(String diminutivo);
    //Método para actualizar un curso.
    CursoResponseDto actualizar(Long id, CursoRequestDto datos);
    //Método para eliminar un curso por su ID.
    void eliminarPorId(Long id);
    //Método para eliminar un curso por su diminutivo.
    void eliminarPorDiminutivo(String diminutivo);
    
}
