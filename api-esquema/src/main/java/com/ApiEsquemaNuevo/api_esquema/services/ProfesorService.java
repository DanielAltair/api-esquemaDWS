package com.ApiEsquemaNuevo.api_esquema.services;

import java.util.List;

import com.ApiEsquemaNuevo.api_esquema.dtos.ProfesorRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.ProfesorResponseDto;

public interface  ProfesorService {
    //Método para crear un profesor.
    ProfesorResponseDto crear(ProfesorRequestDto datos);
    //Método que devuelve una lista de todos los profesores.
    List<ProfesorResponseDto> listar();
    //Método para buscar un profesor por su Id.
    ProfesorResponseDto buscarPorId(Long id);
    //Método para buscar un profesor por su DNI.
    ProfesorResponseDto buscarPorDni(String dni);
    //Método para actualizar un profesor.
    ProfesorResponseDto actualizar(Long id, ProfesorRequestDto datos);
    //Método para eliminar un profesor.
    void eliminar(Long id);
}
