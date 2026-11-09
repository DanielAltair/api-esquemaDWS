package com.ApiEsquemaNuevo.api_esquema.dtos;

import java.time.LocalDate;

public record AlumnoResponseDto(

    Long idAlumno,
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
