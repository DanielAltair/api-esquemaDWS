package com.ApiEsquemaNuevo.api_esquema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "estados")
public class Estado {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_estado")
    private Long idEstado;

    @Column (name = "nombre", nullable = false, length = 10)
    private String nombre;

    @Column (name = "descripcion", length = 250)
    private String descripcion;

    public Estado() {
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}
