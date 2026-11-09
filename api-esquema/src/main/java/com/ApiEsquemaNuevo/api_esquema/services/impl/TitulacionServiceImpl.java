package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiEsquemaNuevo.api_esquema.dtos.TitulacionRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.TitulacionResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Titulacion;
import com.ApiEsquemaNuevo.api_esquema.repositories.TitulacionRepository;
import com.ApiEsquemaNuevo.api_esquema.services.TitulacionService;


@Service 
public class TitulacionServiceImpl implements TitulacionService {

    private final TitulacionRepository titulacionRepository;

    public TitulacionServiceImpl(TitulacionRepository titulacionRepository) {
        this.titulacionRepository = titulacionRepository;
    }
    

  

    @Override
    @Transactional 
    public TitulacionResponseDto actualizar(Long id, TitulacionRequestDto datos) {
        Titulacion titulacion = titulacionRepository.findById(id).orElseThrow();
        
        if(!titulacion.getCodigo().equalsIgnoreCase(datos.codigo()) && titulacionRepository.existsByCodigo(datos.codigo())){
            throw new RuntimeException("Ya existe una titulación con el código: " + datos.codigo());
        }

        if(!titulacion.getDiminutivo().equalsIgnoreCase(datos.diminutivo()) && titulacionRepository.existsByDiminutivo(datos.diminutivo())){
            throw new RuntimeException("Ya existe una titulación con el diminutivo: " + datos.diminutivo());
        }

        titulacion.setDiminutivo(datos.diminutivo());
        titulacion.setCodigo(datos.codigo());
        titulacion.setNotasTotales(datos.horasTotales());


        Titulacion actualizado = titulacionRepository.save(titulacion);

        return mapToResponseDto(actualizado);

    }

    @Override
    @Transactional (readOnly = true)
    public TitulacionResponseDto buscarPorDiminutivo(String diminutivo) {
        Titulacion titulacion = titulacionRepository.findByDiminutivo(diminutivo).orElseThrow();

        return mapToResponseDto(titulacion);
    }

    @Override
    @Transactional (readOnly = true)
    public TitulacionResponseDto buscarPorId(Long id) {
        Titulacion titulacion = titulacionRepository.findById(id).orElseThrow();

        return mapToResponseDto(titulacion);
    }

    @Override
    @Transactional (readOnly = true)
    public TitulacionResponseDto buscarPorCodigo(String codigo) {
        Titulacion titulacion = titulacionRepository.findByCodigo(codigo).orElseThrow();

        return mapToResponseDto(titulacion);
    }

    @Override
    @Transactional 
    public TitulacionResponseDto crear(TitulacionRequestDto datos) {
        if(titulacionRepository.existsByCodigo(datos.codigo())) {
            throw new RuntimeException("Ya existe una titulación con el código: " + datos.codigo());
        }

        if(titulacionRepository.existsByDiminutivo(datos.diminutivo())) {
            throw new RuntimeException("Ya existe una titulación con el diminutivo: " + datos.diminutivo());
        }

        Titulacion titulacion = new Titulacion();


        titulacion.setDiminutivo(datos.diminutivo());
        titulacion.setCodigo(datos.codigo());
        titulacion.setNotasTotales(datos.horasTotales());

        Titulacion guardado = titulacionRepository.save(titulacion);

        return mapToResponseDto(guardado);

    }

    @Override
    @Transactional 
    public void eliminarPorDiminutivo(String diminutivo) {
        Titulacion titulacion = titulacionRepository.findByDiminutivo(diminutivo).orElseThrow();

        titulacionRepository.delete(titulacion);
        
    }

    @Override
    @Transactional 
    public void eliminarPorId(Long id) {
        Titulacion titulacion = titulacionRepository.findById(id).orElseThrow();

        titulacionRepository.delete(titulacion);
        
    }

    @Override
    @Transactional 
    public void eliminarPorCodigo(String Codigo) {
        Titulacion titulacion = titulacionRepository.findByCodigo(Codigo).orElseThrow();

        titulacionRepository.delete(titulacion);
        
    }

    @Override
    @Transactional (readOnly = true)
    public List<TitulacionResponseDto> listar() {
        List<Titulacion> titulacion = titulacionRepository.findAll();

        return titulacion.stream()
        .map(this::mapToResponseDto)
        .toList();
    }

    private TitulacionResponseDto mapToResponseDto(Titulacion titulacion){

        return new TitulacionResponseDto(
            titulacion.getIdTitulacion(),
            titulacion.getCodigo(),
            titulacion.getDiminutivo(),
            titulacion.getNotasTotales()
        );
    }
    
    
}
