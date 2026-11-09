package com.ApiEsquemaNuevo.api_esquema.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column (name = "fecha_baja", length = 50)
    private LocalDate fechaBaja;

    @Column (name = "email_centro", length = 100)
    private String emailCentro;

    @ManyToOne 
    @JoinColumn (name = "id_familia")
    private Familia familia;

    public Alumno() {
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(Integer numeroSS) {
        this.numeroSS = numeroSS;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getEmailCentro() {
        return emailCentro;
    }

    public void setEmailCentro(String emailCentro) {
        this.emailCentro = emailCentro;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
    
}
