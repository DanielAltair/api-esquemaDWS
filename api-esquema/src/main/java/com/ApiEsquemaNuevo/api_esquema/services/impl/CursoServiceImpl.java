package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiEsquemaNuevo.api_esquema.dtos.CursoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.CursoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Curso;
import com.ApiEsquemaNuevo.api_esquema.entities.Titulacion;
import com.ApiEsquemaNuevo.api_esquema.repositories.CursoRepository;
import com.ApiEsquemaNuevo.api_esquema.repositories.TitulacionRepository;
import com.ApiEsquemaNuevo.api_esquema.services.CursoService;

@Service 
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final TitulacionRepository titulacionRepository;
    

   

    public CursoServiceImpl(CursoRepository cursoRepository, TitulacionRepository titulacionRepository) {
        this.cursoRepository = cursoRepository;
        this.titulacionRepository = titulacionRepository;
    }

    @Override
    @Transactional 
    public CursoResponseDto actualizar(Long id, CursoRequestDto datos) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        
        if(!curso.getDiminutivo().equalsIgnoreCase(datos.diminutivo()) && cursoRepository.existsByDiminutivo(datos.diminutivo())){
            throw new RuntimeException("Ya existe un curso con el diminutivo: " + datos.diminutivo());
        }

        curso.setDiminutivo(datos.diminutivo());
        curso.setDescripcion(datos.descripcion());

        if(datos.idTitulacion() != null){
            Titulacion titulacion = titulacionRepository.findById(datos.idTitulacion()).orElseThrow(); 
            curso.setTitulacion(titulacion);
        }else{
            curso.setTitulacion(null);
        }

        Curso actualizado = cursoRepository.save(curso);

        return mapToResponseDto(actualizado);

    }

    @Override
    @Transactional (readOnly = true)
    public CursoResponseDto buscarPorDiminutivo(String diminutivo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional (readOnly = true)
    public CursoResponseDto buscarPorID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional 
    public CursoResponseDto crear(CursoRequestDto datos) {
        if(cursoRepository.existsByDiminutivo(datos.diminutivo())) {
            throw new RuntimeException("Ya existe un curso con el diminutivo: " + datos.diminutivo());
        }

        Curso curso = new Curso();

        if(datos.idTitulacion() != null){
            Titulacion titulacion = titulacionRepository.findById(datos.idTitulacion()).orElseThrow(); 
            curso.setTitulacion(titulacion);
        }


        curso.setDiminutivo(datos.diminutivo());
        curso.setDescripcion(datos.descripcion());

        Curso guardado = cursoRepository.save(curso);

        return mapToResponseDto(guardado);

    }

    @Override
    public void eliminarPorDiminutivo(String diminutivo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void eliminarPorId(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    @Transactional (readOnly = true)
    public List<CursoResponseDto> listar() {
        // TODO Auto-generated method stub
        return null;
    }

    private CursoResponseDto mapToResponseDto(Curso curso){

        Long idTitulacion = null;

        if(curso.getTitulacion() != null){
            idTitulacion = curso.getTitulacion().getIdTitulacion();
        }

        return new CursoResponseDto(
            curso.getIdCurso(),
            curso.getDiminutivo(),
            curso.getDescripcion(),
            idTitulacion
        );
    }
    
    
}
