package com.ApiEsquemaNuevo.api_esquema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiEsquemaNuevo.api_esquema.entities.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {

    //Buscar por UK
    Optional<Modulo> findByCodigo(String codigo);
    Optional<Modulo> findByDiminutivo(String diminutivo);

    //Comprobar si existe por UK
    boolean existsByCodigo(String codigo);
    boolean existsByDiminutivo(String diminutivo);

    //Eliminar por UK
    void deleteByCodigo(String codigo);
    void deleteByDiminutivo(String diminutivo);
    
}
