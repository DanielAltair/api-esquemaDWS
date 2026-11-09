package com.ApiEsquemaNuevo.api_esquema.services;

import java.util.List;

import com.ApiEsquemaNuevo.api_esquema.dtos.AlumnoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.AlumnoResponseDto;

public interface AlumnoService {
    //Método para crear un alumno.
    AlumnoResponseDto crear (AlumnoRequestDto datos);
    //Método para listar los alumnos.
    List<AlumnoResponseDto> listar();
    //Método para actualizar los alumnos;
    AlumnoResponseDto actualizar (Long id, AlumnoRequestDto datos);
    //Método para buscar por id.
    AlumnoResponseDto buscarPorId(Long id);
    //Método para buscar por dni.
    AlumnoResponseDto buscarPorDni(String dni);
    //Método para buscar por numeroSS.
    AlumnoResponseDto buscarPorNumeroSS(Integer numeroSS);
    //Método para eliminar por id.
    void  eliminarPorId(Long id);
    //Método para eliminar por numeroSS.
    void  eliminarPorNumeroSS(Integer numeroSS);
    //Método para eliminar por dni.
    void  eliminarPorDni(String dni);
}
