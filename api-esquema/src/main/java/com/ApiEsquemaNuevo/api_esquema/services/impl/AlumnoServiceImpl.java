package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import com.ApiEsquemaNuevo.api_esquema.dtos.AlumnoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.AlumnoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Alumno;
import com.ApiEsquemaNuevo.api_esquema.repositories.AlumnoRepository;
import com.ApiEsquemaNuevo.api_esquema.services.AlumnoService;

public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;
    

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public AlumnoResponseDto actualizar(Long id, AlumnoRequestDto datos) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AlumnoResponseDto buscarPorDni(String dni) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AlumnoResponseDto buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AlumnoResponseDto buscarPorNumeroSS(Integer numeroSS) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AlumnoResponseDto crear(AlumnoRequestDto datos) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AlumnoResponseDto eliminarPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AlumnoResponseDto eliminarPorNumeroSS(Integer numeroSS) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AlumnoResponseDto> listar() {
        // TODO Auto-generated method stub
        return null;
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
