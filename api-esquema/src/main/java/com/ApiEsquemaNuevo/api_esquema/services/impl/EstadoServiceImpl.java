package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiEsquemaNuevo.api_esquema.dtos.EstadoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.EstadoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Estado;
import com.ApiEsquemaNuevo.api_esquema.repositories.EstadoRepository;
import com.ApiEsquemaNuevo.api_esquema.services.EstadoService;

@Service 
public class EstadoServiceImpl implements EstadoService {
    private final EstadoRepository estadoRepository;

    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    @Transactional 
    public EstadoResponseDto actualizar(Long id, EstadoRequestDto datos) {
        Estado estado = estadoRepository.findById(id).orElseThrow();

        estado.setNombre(datos.nombre());
        estado.setDescripcion(datos.descripcion());

        Estado actualizado = estadoRepository.save(estado);

        return mapEstadoResponseDto(actualizado);
    }

    @Override
    @Transactional (readOnly = true)
    public EstadoResponseDto buscarPorId(Long id) {
        Estado estado = estadoRepository.findById(id).orElseThrow();
        
        return mapEstadoResponseDto(estado);
    }

    @Override
    @Transactional
    public EstadoResponseDto crear(EstadoRequestDto datos) {
        Estado estado = new Estado();

        if(datos.nombre().equals(estado.getNombre())){
            throw new RuntimeException("Ya existe un estado con el nombre: " + datos.nombre());
        }

        estado.setNombre(datos.nombre());
        estado.setDescripcion(datos.descripcion());

        Estado guardado = estadoRepository.save(estado);

        return mapEstadoResponseDto(guardado);
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        Estado estado = estadoRepository.findById(id).orElseThrow();

        estadoRepository.delete(estado);
        
    }

    @Override
    @Transactional (readOnly = true)
    public List<EstadoResponseDto> listar() {
        List<Estado> estado = estadoRepository.findAll();

        return estado.stream()
        .map(this::mapEstadoResponseDto)
        .toList();
    }

    private EstadoResponseDto mapEstadoResponseDto(Estado estado){
        return new EstadoResponseDto(
            estado.getIdEstado(),
            estado.getNombre(),
            estado.getDescripcion()
        );

    };
    
}
