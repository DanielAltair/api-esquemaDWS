package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiEsquemaNuevo.api_esquema.dtos.ModuloRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.ModuloResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Modulo;
import com.ApiEsquemaNuevo.api_esquema.exceptions.ModuloAlreadyExistsException;
import com.ApiEsquemaNuevo.api_esquema.exceptions.ModuloNotFoundException;
import com.ApiEsquemaNuevo.api_esquema.repositories.ModuloRepository;
import com.ApiEsquemaNuevo.api_esquema.services.ModuloService;


@Service 
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;

    public ModuloServiceImpl(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    @Override
    @Transactional 
    public ModuloResponseDto crear(ModuloRequestDto datos) {

        if(moduloRepository.existsByCodigo(datos.codigo())){
            throw new ModuloAlreadyExistsException("Ya existe un módulo con el código: " + datos.codigo());
        } 
        
        if(moduloRepository.existsByDiminutivo(datos.diminutivo())){
            throw new ModuloAlreadyExistsException("Ya existe un módulo con el diminutivo: " + datos.diminutivo());
        }
        
        Modulo modulo = new Modulo();

        modulo.setCodigo(datos.codigo());
        modulo.setDiminutivo(datos.diminutivo());
        modulo.setNombre(datos.nombre());
        modulo.setDescripcion(datos.descripcion());
        modulo.setHorasSemanales(datos.horasSemanales());
        modulo.setCreditos(datos.creditos());

        modulo = moduloRepository.save(modulo);
        return mapToResponseDto(modulo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ModuloResponseDto> listar() {
       List<Modulo> modulos = moduloRepository.findAll();

       return modulos.stream()
        .map(this::mapToResponseDto)
        .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ModuloResponseDto buscarPorId(Long id) {
        Modulo modulo = moduloRepository.findById(id).orElseThrow(() -> new ModuloNotFoundException("No existe un modulo con el ID indicado"));
        return mapToResponseDto(modulo);
    }

    @Override
    @Transactional(readOnly = true)
    public ModuloResponseDto buscarPorCodigo(String codigo) {
        Modulo modulo = moduloRepository.findByCodigo(codigo).orElseThrow(() -> new ModuloNotFoundException("No existe un modulo con el código indicado"));
        return mapToResponseDto(modulo);
    }

    @Override
    @Transactional(readOnly = true)
    public ModuloResponseDto buscarPorDiminutivo(String diminutivo) {
        Modulo modulo = moduloRepository.findByDiminutivo(diminutivo).orElseThrow(() -> new ModuloNotFoundException("No existe un modulo con el diminutivo indicado"));
        return mapToResponseDto(modulo);
    }

    @Override
    @Transactional
    public ModuloResponseDto actualizarPorId(Long id, ModuloRequestDto datos) {
        Modulo modulo = moduloRepository.findById(id).orElseThrow(() -> new ModuloNotFoundException("No existe un modulo con el ID indicado"));

        if(!modulo.getCodigo().equals(datos.codigo()) && moduloRepository.existsByCodigo(datos.codigo())){
            throw new ModuloAlreadyExistsException("Ya existe un módulo con el código: " + datos.codigo());
        }

        if(!modulo.getDiminutivo().equals(datos.diminutivo()) && moduloRepository.existsByDiminutivo(datos.diminutivo())){
            throw new ModuloAlreadyExistsException("Ya existe un módulo con el diminutivo: " + datos.diminutivo());
        }

        modulo.setCodigo(datos.codigo());
        modulo.setDiminutivo(datos.diminutivo());
        modulo.setNombre(datos.nombre());
        modulo.setDescripcion(datos.descripcion());
        modulo.setHorasSemanales(datos.horasSemanales());
        modulo.setCreditos(datos.creditos());

        modulo = moduloRepository.save(modulo);
        return mapToResponseDto(modulo);
    }

      @Override
    @Transactional
    public ModuloResponseDto actualizarPorCodigo(String codigo, ModuloRequestDto datos) {
        Modulo modulo = moduloRepository.findByCodigo(codigo).orElseThrow(() -> new ModuloNotFoundException("No existe un modulo con el código indicado"));

        if(!modulo.getCodigo().equals(datos.codigo()) && moduloRepository.existsByCodigo(datos.codigo())){
            throw new ModuloAlreadyExistsException("Ya existe un módulo con el código: " + datos.codigo());
        }

        if(!modulo.getDiminutivo().equals(datos.diminutivo()) && moduloRepository.existsByDiminutivo(datos.diminutivo())){
            throw new ModuloAlreadyExistsException("Ya existe un módulo con el diminutivo: " + datos.diminutivo());
        }

        modulo.setCodigo(datos.codigo());
        modulo.setDiminutivo(datos.diminutivo());
        modulo.setNombre(datos.nombre());
        modulo.setDescripcion(datos.descripcion());
        modulo.setHorasSemanales(datos.horasSemanales());
        modulo.setCreditos(datos.creditos());

        modulo = moduloRepository.save(modulo);
        return mapToResponseDto(modulo);
    }

      @Override
    @Transactional
    public ModuloResponseDto actualizarPorDiminutivo(String diminutivo, ModuloRequestDto datos) {
        Modulo modulo = moduloRepository.findByDiminutivo(diminutivo).orElseThrow(() -> new ModuloNotFoundException("No existe un modulo con el diminutivo indicado"));

        if(!modulo.getCodigo().equals(datos.codigo()) && moduloRepository.existsByCodigo(datos.codigo())){
            throw new ModuloAlreadyExistsException("Ya existe un módulo con el código: " + datos.codigo());
        }

        if(!modulo.getDiminutivo().equals(datos.diminutivo()) && moduloRepository.existsByDiminutivo(datos.diminutivo())){
            throw new ModuloAlreadyExistsException("Ya existe un módulo con el diminutivo: " + datos.diminutivo());
        }

        modulo.setCodigo(datos.codigo());
        modulo.setDiminutivo(datos.diminutivo());
        modulo.setNombre(datos.nombre());
        modulo.setDescripcion(datos.descripcion());
        modulo.setHorasSemanales(datos.horasSemanales());
        modulo.setCreditos(datos.creditos());

        modulo = moduloRepository.save(modulo);
        return mapToResponseDto(modulo);
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        Modulo modulo = moduloRepository.findById(id).orElseThrow(() -> new ModuloNotFoundException("No existe un modulo con el ID indicado"));
        moduloRepository.delete(modulo);
    }

    @Override
    @Transactional
    public void eliminarPorCodigo(String codigo) {
        Modulo modulo = moduloRepository.findByCodigo(codigo).orElseThrow(() -> new ModuloNotFoundException("No existe un modulo con el código indicado"));
        moduloRepository.delete(modulo);
    }

    @Override
    @Transactional
    public void eliminarPorDiminutivo(String diminutivo) {
        Modulo modulo = moduloRepository.findByDiminutivo(diminutivo).orElseThrow(() -> new ModuloNotFoundException("No existe un modulo con el diminutivo indicado"));
        moduloRepository.delete(modulo);
    }
    
    private ModuloResponseDto mapToResponseDto(Modulo modulo){
        return new ModuloResponseDto(
            modulo.getIdModulo(),
            modulo.getCodigo(),
            modulo.getDiminutivo(),
            modulo.getNombre(),
            modulo.getDescripcion(),
            modulo.getHorasSemanales(),
            modulo.getCreditos()
        );
    }
}
