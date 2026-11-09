package com.ApiEsquemaNuevo.api_esquema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiEsquemaNuevo.api_esquema.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
    
}