package com.ApiEsquemaNuevo.api_esquema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiEsquemaNuevo.api_esquema.entities.Titulacion;

public interface TitulacionRepository extends JpaRepository<Titulacion, Long> {
    //Buscar por UK
    Optional<Titulacion> findByCodigo(String codigo);
    Optional<Titulacion> findByDiminutivo(String diminutivo);

    //Comprobar si existe por UK
    boolean existsByCodigo(String codigo);
    boolean existsByDiminutivo(String diminutivo);
    
    //Eliminar por UK
    void deleteByCodigo(String codigo);
    void deleteByDiminutivo(String diminutivo);
}
