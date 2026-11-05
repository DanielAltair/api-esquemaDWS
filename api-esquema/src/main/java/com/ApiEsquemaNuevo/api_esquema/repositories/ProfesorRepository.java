package com.ApiEsquemaNuevo.api_esquema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiEsquemaNuevo.api_esquema.entities.Profesor;

public interface  ProfesorRepository extends JpaRepository<Profesor, Long> {

    Optional<Profesor> findByDni(String dni);
    boolean existsByDni(String dni);
}
