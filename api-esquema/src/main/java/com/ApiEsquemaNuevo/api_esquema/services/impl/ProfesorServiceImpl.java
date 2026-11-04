package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiEsquemaNuevo.api_esquema.dtos.ProfesorRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.ProfesorResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Departamento;
import com.ApiEsquemaNuevo.api_esquema.entities.Profesor;
import com.ApiEsquemaNuevo.api_esquema.repositories.DepartamentoRepository;
import com.ApiEsquemaNuevo.api_esquema.repositories.ProfesorRepository;
import com.ApiEsquemaNuevo.api_esquema.services.ProfesorService;



@Service 
public class ProfesorServiceImpl implements ProfesorService  {

    private final ProfesorRepository profesorRepository;
    private final DepartamentoRepository departamentoRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository, DepartamentoRepository departamentoRepository) {
        this.profesorRepository = profesorRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    @Transactional
    public ProfesorResponseDto crear(ProfesorRequestDto datos) {
        
        Profesor profesor = new Profesor();

         if (datos.idDepartamento() != null) {
            Departamento departamento = departamentoRepository.findById(datos.idDepartamento()).orElseThrow();

            profesor.setDepartamento(departamento);
        }

        profesor.setDni(datos.dni());
        profesor.setNombre(datos.nombre());
        profesor.setApellidos(datos.apellidos());
        profesor.setEmailCentro(datos.emailCentro());
        profesor.setEmailPersonal(datos.emailPersonal());
        profesor.setTelefonoPersonal(datos.telefonoPersonal());
    

        Profesor guardado = profesorRepository.save(profesor);

        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional (readOnly = true)
    public List<ProfesorResponseDto> listar() {
        List<Profesor> profesores = profesorRepository.findAll();

        return profesores.stream()
            .map(this::mapToResponseDto)
            .toList();
    }

    @Override
    @Transactional (readOnly = true)
    public ProfesorResponseDto buscarPorId(Long id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow();

        return mapToResponseDto(profesor);
    }

    @Override
    @Transactional (readOnly = true)
    public ProfesorResponseDto buscarPorDni(String dni) {
        Profesor profesor = profesorRepository.findByDni(dni).orElseThrow();
        
        return mapToResponseDto(profesor);
    }

    @Override
    @Transactional 
    public ProfesorResponseDto actualizar(Long id, ProfesorRequestDto datos) {

        Profesor profesor = profesorRepository.findById(id).orElseThrow();

        profesor.setDni(datos.dni());
        profesor.setNombre(datos.nombre());
        profesor.setApellidos(datos.apellidos());
        profesor.setEmailCentro(datos.emailCentro());
        profesor.setEmailPersonal(datos.emailPersonal());
        profesor.setTelefonoPersonal(datos.telefonoPersonal());

        if(datos.idDepartamento() != null){
            Departamento departamento = departamentoRepository.findById(datos.idDepartamento()).orElseThrow();
            profesor.setDepartamento(departamento);
        }else{
            profesor.setDepartamento(null);
        }

        Profesor actualizado = profesorRepository.save(profesor);

        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional 
    public void eliminar(Long id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow();

        profesorRepository.delete(profesor);
    }
    
   private ProfesorResponseDto mapToResponseDto(Profesor profesor){

        Long idDepartamento = null;

        if(profesor.getDepartamento() !=null ){
            idDepartamento = profesor.getDepartamento().getIdDepartamento();
        }

        return new ProfesorResponseDto(
            profesor.getIdProfesor(),
            profesor.getDni(),
            profesor.getNombre(),
            profesor.getApellidos(),
            profesor.getEmailCentro(),
            profesor.getEmailPersonal(),
            profesor.getTelefonoPersonal(),
            idDepartamento
        );
   }
}
