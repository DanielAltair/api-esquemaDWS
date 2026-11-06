package com.ApiEsquemaNuevo.api_esquema.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "relacion_modulo_curso") 
public class RelacionModuloCurso {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idRelacionModuloCurso;
    
    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)  
    private Modulo modulo;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)  
    private Curso curso;

    public RelacionModuloCurso() {
    }

    public Long getIdRelacionModuloCurso() {
        return idRelacionModuloCurso;
    }

    public void setIdRelacionModuloCurso(Long idRelacionModuloCurso) {
        this.idRelacionModuloCurso = idRelacionModuloCurso;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
