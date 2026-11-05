package com.ApiEsquemaNuevo.api_esquema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "modulos")
public class Modulo {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private Long idModulo;

    @Column (name = "codigo", nullable = false, unique = true, length = 5)
    private String codigo;

    @Column (name = "diminutivo", nullable = false, unique = true, length = 5)
    private String diminutivo;

    @Column (name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column (name = "descripcion", length = 250)
    private String descripcion;
    
    @Column (name = "horas_Semanales")
    private Integer horasSemanales;

    @Column (name = "creditos")
    private Integer creditos;

}
