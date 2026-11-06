package com.ApiEsquemaNuevo.api_esquema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiEsquemaNuevo.api_esquema.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    //Buscar por UK
    Optional<Curso> findByDiminutivo(String diminutivo);
    //Comprobar si existe por UK
    boolean existsByDiminutivo(String diminutivo);
    //Eliminar por UK
    void deleteByDiminutivo(String diminutivo);

}
