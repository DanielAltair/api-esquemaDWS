package com.ApiEsquemaNuevo.api_esquema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "relacion_modulo_estado_alumno")
public class RelacionModuloEstadoAlumno {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
     @Column (name = "id_relacion_modulo_estado_alumno")
    private Long IdRelacionModuloEstadoAlumno;

    @ManyToOne 
    @JoinColumn (name = "id_modulo", nullable = false)
    private Modulo modulo;

    @ManyToOne 
    @JoinColumn (name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne 
    @JoinColumn (name = "id_estado", nullable = false)
    private Estado estado;

    public RelacionModuloEstadoAlumno() {
    }

    public Long getIdRelacionModuloEstadoAlumno() {
        return IdRelacionModuloEstadoAlumno;
    }

    public void setIdRelacionModuloEstadoAlumno(Long idRelacionModuloEstadoAlumno) {
        IdRelacionModuloEstadoAlumno = idRelacionModuloEstadoAlumno;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
