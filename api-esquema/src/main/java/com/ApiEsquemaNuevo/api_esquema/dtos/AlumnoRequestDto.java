package com.ApiEsquemaNuevo.api_esquema.dtos;

import java.time.LocalDate;

public record AlumnoRequestDto(

    String nombre,
    String apellidos,
    String dni,
    Integer numeroSS,
    String emailPersonal,
    String telefonoPersonal,
    LocalDate fechaAlta,
    LocalDate fechaBaja,
    String emailCentro,
    Long idFamilia
) 
{}
