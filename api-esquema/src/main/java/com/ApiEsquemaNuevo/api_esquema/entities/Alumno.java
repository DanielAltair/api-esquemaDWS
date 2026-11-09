package com.ApiEsquemaNuevo.api_esquema.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "alumnos") 
public class Alumno {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_alumno")
    private Long idAlumno;

    @Column (name = "nombre", nullable = false, length = 10)
    private String nombre;

    @Column (name = "apellidos", nullable = false, length = 30)
    private String apellidos;

    @Column (name = "dni", nullable = false, unique = true, length = 9)
    private String dni;

    @Column (name = "numero_SS", unique = true, length = 13)
    private Integer numeroSS;

    @Column (name = "email_personal", length = 100)
    private String emailPersonal;

    @Column (name = "telefono_personal", length = 13)
    private String telefonoPersonal;

    @Column (name = "fecha_alta", nullable = false, length = 50)
    private LocalDate fechaAlta;
}
