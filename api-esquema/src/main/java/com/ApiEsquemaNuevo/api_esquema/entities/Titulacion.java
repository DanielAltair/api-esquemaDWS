package com.ApiEsquemaNuevo.api_esquema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "titulaciones")
public class Titulacion {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idTitulacion;

    @Column (name = "codigo", nullable = false, unique = true, length = 5)
    private String codigo;

    @Column (name = "diminutivo", nullable = false, unique = true, length = 5)
    private String diminutivo;

    @Column (name = "notas_Totales")
    private Double notasTotales;

    public Titulacion() {
    }

    public Long getIdTitulacion() {
        return idTitulacion;
    }

    public void setIdTitulacion(Long idTitulacion) {
        this.idTitulacion = idTitulacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public Double getNotasTotales() {
        return notasTotales;
    }

    public void setNotasTotales(Double notasTotales) {
        this.notasTotales = notasTotales;
    }
    
}
