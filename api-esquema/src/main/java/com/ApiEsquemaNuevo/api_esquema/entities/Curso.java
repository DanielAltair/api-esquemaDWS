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
@Table (name = "cursos")
public class Curso {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_curso")
    private Long idCurso;

    @Column (name = "diminutivo", nullable = false, unique = true, length = 5)
    private String diminutivo;

    @Column (name = "descripcion", length = 250)
    private String descripcion;

    @ManyToOne 
    @JoinColumn (name = "id_titulacion")
    private Titulacion titulacion;

    public Curso() {
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Titulacion getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(Titulacion titulacion) {
        this.titulacion = titulacion;
    }
    
}
