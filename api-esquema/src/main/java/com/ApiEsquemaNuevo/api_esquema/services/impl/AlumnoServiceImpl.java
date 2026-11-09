package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiEsquemaNuevo.api_esquema.dtos.AlumnoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.AlumnoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Alumno;
import com.ApiEsquemaNuevo.api_esquema.entities.Familia;
import com.ApiEsquemaNuevo.api_esquema.repositories.AlumnoRepository;
import com.ApiEsquemaNuevo.api_esquema.repositories.FamiliaRepository;
import com.ApiEsquemaNuevo.api_esquema.services.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final FamiliaRepository familiaRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, FamiliaRepository familiaRepository) {
        this.alumnoRepository = alumnoRepository;
        this.familiaRepository = familiaRepository;
    }

    @Override
    @Transactional 
    public AlumnoResponseDto actualizar(Long id, AlumnoRequestDto datos) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow();

        if(!alumno.getDni().equalsIgnoreCase(datos.dni()) && alumnoRepository.existsByDni(datos.dni())){
            throw new RuntimeException("Ya existe un alumno con el dni: " + datos.dni());
        }

        if(!alumno.getNumeroSS().equals(datos.numeroSS()) && alumnoRepository.existsByNumeroSS(datos.numeroSS())){
            throw new RuntimeException("Ya existe un alumno con el número: " + datos.numeroSS());
        }

        alumno.setDni(datos.dni());
        alumno.setNumeroSS(datos.numeroSS());

        if(datos.idFamilia() != null){
            Familia familia = familiaRepository.findById(datos.idFamilia()).orElseThrow();
            alumno.setFamilia(familia);
        }else{
            alumno.setFamilia(null);
        }

        Alumno actualizado = alumnoRepository.save(alumno);

        return mapAlumnoResponseDto(actualizado);
    }

    @Override
    @Transactional (readOnly = true)
    public AlumnoResponseDto buscarPorDni(String dni) {
        Alumno alumno = alumnoRepository.findByDni(dni).orElseThrow();

        return mapAlumnoResponseDto(alumno);
    }

    @Override
    @Transactional (readOnly = true)
    public AlumnoResponseDto buscarPorId(Long id) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow();

        return mapAlumnoResponseDto(alumno);
    }

    @Override
    @Transactional (readOnly = true)
    public AlumnoResponseDto buscarPorNumeroSS(Integer numeroSS) {
        Alumno alumno = alumnoRepository.findByNumeroSS(numeroSS).orElseThrow();

        return mapAlumnoResponseDto(alumno);
    }

    @Override
    @Transactional 
    public AlumnoResponseDto crear(AlumnoRequestDto datos) {
       if (alumnoRepository.existsByDni(datos.dni())) {
           throw new RuntimeException("Ya existe un alumno con el dni: " + datos.dni());
       }

       if (alumnoRepository.existsByNumeroSS(datos.numeroSS())) {
           throw new RuntimeException("Ya existe un alumno con el número: " + datos.numeroSS());
       }

       Alumno alumno = new Alumno();

       if(datos.idFamilia() != null){
            Familia familia = familiaRepository.findById(datos.idFamilia()).orElseThrow();
            alumno.setFamilia(familia);
       }

       alumno.setDni(datos.dni());
       alumno.setNumeroSS(datos.numeroSS());

       Alumno guardado = alumnoRepository.save(alumno);

       return mapAlumnoResponseDto(guardado);
    }

    @Override
    @Transactional
    public void  eliminarPorId(Long id) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow();

        alumnoRepository.delete(alumno);
    }

    @Override
    @Transactional
    public void  eliminarPorNumeroSS(Integer numeroSS) {
        Alumno alumno = alumnoRepository.findByNumeroSS(numeroSS).orElseThrow();

        alumnoRepository.delete(alumno);
    }

    @Override
    @Transactional
    public void  eliminarPorDni(String dni) {
        Alumno alumno = alumnoRepository.findByDni(dni).orElseThrow();

        alumnoRepository.delete(alumno);
    }

    @Override
    @Transactional
    public List<AlumnoResponseDto> listar() {
        List<Alumno> alumno = alumnoRepository.findAll();

        return alumno.stream()
        .map(this::mapAlumnoResponseDto)
        .toList();
    }

    private AlumnoResponseDto mapAlumnoResponseDto(Alumno alumno){
        Long idFamilia = null;
        if(alumno.getFamilia() !=null){
            idFamilia = alumno.getFamilia().getIdFamilia();
        }

        return new AlumnoResponseDto(
            alumno.getIdAlumno(),
            alumno.getNombre(),
            alumno.getApellidos(),
            alumno.getDni(),
            alumno.getNumeroSS(),
            alumno.getEmailPersonal(),
            alumno.getTelefonoPersonal(),
            alumno.getFechaAlta(),
            alumno.getFechaBaja(),
            alumno.getEmailCentro(),
            idFamilia
        );
    }
    
    
}
