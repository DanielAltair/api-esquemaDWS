package com.ApiEsquemaNuevo.api_esquema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiEsquemaNuevo.api_esquema.entities.Departamento;
import java.util.Optional;


public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    
    Optional<Departamento> findByCodigo(String codigo);
    
}
