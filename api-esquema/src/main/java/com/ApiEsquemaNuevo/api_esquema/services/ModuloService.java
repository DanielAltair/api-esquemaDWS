package com.ApiEsquemaNuevo.api_esquema.services;

import java.util.List;

import com.ApiEsquemaNuevo.api_esquema.dtos.ModuloRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.ModuloResponseDto;

public interface ModuloService {
   //Método para crear un nuevo módulo.
   ModuloResponseDto crear(ModuloRequestDto datos);
   //Método que devuelve una lista de todos los módulos.   
   List<ModuloResponseDto> listar();
   //Método para buscar un módulo por su ID.
   ModuloResponseDto buscarPorId(Long id);
   //Método para buscar un módulo por su código.   
   ModuloResponseDto buscarPorCodigo(String codigo); 
   //Método para buscar un módulo por su diminutivo.
   ModuloResponseDto buscarPorDiminutivo(String diminutivo);
   //Método para actualizar un módulo por su ID.
   ModuloResponseDto actualizarPorId(Long id, ModuloRequestDto datos);
    //Método para actualizar un módulo por su código.
   ModuloResponseDto actualizarPorCodigo(String codigo, ModuloRequestDto datos);
    //Método para actualizar un módulo por su diminutivo.
   ModuloResponseDto actualizarPorDiminutivo(String diminutivo, ModuloRequestDto datos);
   //Método para eliminar un módulo por su ID.
   void eliminarPorId(Long id);
   //Método para eliminar un módulo por su código.
   void eliminarPorCodigo(String codigo);
   //Método para eliminar un módulo por su diminutivo.
   void eliminarPorDiminutivo(String diminutivo);
}

