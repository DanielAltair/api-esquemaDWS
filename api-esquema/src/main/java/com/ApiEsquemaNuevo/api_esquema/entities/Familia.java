package com.ApiEsquemaNuevo.api_esquema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "familias")
public class Familia {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_familia")
    private Long idFamilia;

    @Column (name = "son_separados")
    private boolean sonSeparados;

    @Column (name = "es_compartida")
    private boolean esCompartida;

    @Column (name = "es_padre")
    private boolean esPadre;

    @Column (name = "es_madre")
    private boolean esMadre;

    //Atributos padre.
    @Column (name = "nombre_padre", length = 30)
    private String nombrePadre;

    @Column (name = "apellidos_padre", length = 50)
    private String apellidosPadre;
    
    @Column (name = "email_padre", length = 50)
    private String emailPadre;

    @Column (name = "telefono_padre", length = 50)
    private String telefonoPadre;

    @Column (name = "direccion_padre", length = 50)
    private String direccionPadre;

    @Column (name = "cp_padre", length = 5)
    private Integer cpPadre;

    @Column (name = "provincia_padre", length = 50)
    private String provinciaPadre;

    //Atributos madre.
     @Column (name = "nombre_madre", length = 30)
    private String nombreMadre;

    @Column (name = "apellidos_madre", length = 50)
    private String apellidosMadre;
    
    @Column (name = "email_madre", length = 50)
    private String emailMadre;

    @Column (name = "telefono_madre", length = 50)
    private String telefonoMadre;

    @Column (name = "direccion_madre", length = 50)
    private String direccionMadre;

    @Column (name = "cp_madre", length = 5)
    private Integer cpMadre;

    @Column (name = "provincia_madre", length = 50)
    private String provinciaMadre;

    public Familia() {
    }

    public Long getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Long idFamilia) {
        this.idFamilia = idFamilia;
    }

    public boolean isSonSeparados() {
        return sonSeparados;
    }

    public void setSonSeparados(boolean sonSeparados) {
        this.sonSeparados = sonSeparados;
    }

    public boolean isEsCompartida() {
        return esCompartida;
    }

    public void setEsCompartida(boolean esCompartida) {
        this.esCompartida = esCompartida;
    }

    public boolean isEsPadre() {
        return esPadre;
    }

    public void setEsPadre(boolean esPadre) {
        this.esPadre = esPadre;
    }

    public boolean isEsMadre() {
        return esMadre;
    }

    public void setEsMadre(boolean esMadre) {
        this.esMadre = esMadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getApellidosPadre() {
        return apellidosPadre;
    }

    public void setApellidosPadre(String apellidosPadre) {
        this.apellidosPadre = apellidosPadre;
    }

    public String getEmailPadre() {
        return emailPadre;
    }

    public void setEmailPadre(String emailPadre) {
        this.emailPadre = emailPadre;
    }

    public String getTelefonoPadre() {
        return telefonoPadre;
    }

    public void setTelefonoPadre(String telefonoPadre) {
        this.telefonoPadre = telefonoPadre;
    }

    public String getDireccionPadre() {
        return direccionPadre;
    }

    public void setDireccionPadre(String direccionPadre) {
        this.direccionPadre = direccionPadre;
    }

    public Integer getCpPadre() {
        return cpPadre;
    }

    public void setCpPadre(Integer cpPadre) {
        this.cpPadre = cpPadre;
    }

    public String getProvinciaPadre() {
        return provinciaPadre;
    }

    public void setProvinciaPadre(String provinciaPadre) {
        this.provinciaPadre = provinciaPadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getApellidosMadre() {
        return apellidosMadre;
    }

    public void setApellidosMadre(String apellidosMadre) {
        this.apellidosMadre = apellidosMadre;
    }

    public String getEmailMadre() {
        return emailMadre;
    }

    public void setEmailMadre(String emailMadre) {
        this.emailMadre = emailMadre;
    }

    public String getTelefonoMadre() {
        return telefonoMadre;
    }

    public void setTelefonoMadre(String telefonoMadre) {
        this.telefonoMadre = telefonoMadre;
    }

    public String getDireccionMadre() {
        return direccionMadre;
    }

    public void setDireccionMadre(String direccionMadre) {
        this.direccionMadre = direccionMadre;
    }

    public Integer getCpMadre() {
        return cpMadre;
    }

    public void setCpMadre(Integer cpMadre) {
        this.cpMadre = cpMadre;
    }

    public String getProvinciaMadre() {
        return provinciaMadre;
    }

    public void setProvinciaMadre(String provinciaMadre) {
        this.provinciaMadre = provinciaMadre;
    }
    
}
