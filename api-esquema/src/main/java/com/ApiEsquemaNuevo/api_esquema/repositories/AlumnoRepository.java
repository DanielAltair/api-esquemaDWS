package com.ApiEsquemaNuevo.api_esquema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiEsquemaNuevo.api_esquema.entities.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

    //Buscar por UK
    Optional<Alumno> findByDni(String dni);
    Optional<Alumno> findByNumeroSS(Integer numeroSS);
    
    //Comprobar si existe por UK
    boolean existsByDni(String dni);
    boolean existsByNumeroSS(Integer numeroSS);

    //Eliminar por UK
    void deleteByDni(String dni);
    void deleteByDniNumeroSS(Integer numeroSS);
}
