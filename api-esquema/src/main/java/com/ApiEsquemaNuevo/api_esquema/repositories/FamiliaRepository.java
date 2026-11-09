package com.ApiEsquemaNuevo.api_esquema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiEsquemaNuevo.api_esquema.entities.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Long>{
    
}
