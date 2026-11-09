package com.ApiEsquemaNuevo.api_esquema.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiEsquemaNuevo.api_esquema.dtos.AlumnoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.AlumnoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.services.AlumnoService;

@RestController 
@RequestMapping ("api/alumnos")
public class AlumnoController {
    private final AlumnoService alumnoservice;

    public AlumnoController(AlumnoService alumnoservice) {
        this.alumnoservice = alumnoservice;
    }
    
    @GetMapping 
    public ResponseEntity<List<AlumnoResponseDto>> listar(){
        return ResponseEntity.ok(alumnoservice.listar());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<AlumnoResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(alumnoservice.buscarPorId(id));
    }

    @GetMapping ("/dni/{dni}")
    public ResponseEntity<AlumnoResponseDto> buscarPorDni(@PathVariable String dni){
        return ResponseEntity.ok(alumnoservice.buscarPorDni(dni));
    }

    @GetMapping ("/numeroSS/{numeroSS}")
    public ResponseEntity<AlumnoResponseDto> buscarPorNumeroSS(@PathVariable Integer numeroSS){
        return ResponseEntity.ok(alumnoservice.buscarPorNumeroSS(numeroSS));
    }

    @PostMapping
    public ResponseEntity<AlumnoResponseDto> crear(@RequestBody AlumnoRequestDto datos){
        AlumnoResponseDto creado = alumnoservice.crear(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PostMapping ("/{id}")
    public ResponseEntity<AlumnoResponseDto> actualizar(@PathVariable Long id, @RequestBody AlumnoRequestDto datos){
        AlumnoResponseDto actualizado = alumnoservice.actualizar(id, datos);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        alumnoservice.eliminarPorId(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping ("/dni/{dni}")
    public ResponseEntity<Void> eliminarPorDni(@PathVariable String dni){
        alumnoservice.eliminarPorDni(dni);

        return ResponseEntity.noContent().build();
    }

     @DeleteMapping ("/numeroSS/{numeroSS}")
    public ResponseEntity<Void> eliminarPorNumeroSS(@PathVariable Integer numeroSS){
        alumnoservice.eliminarPorNumeroSS(numeroSS);

        return ResponseEntity.noContent().build();
    }
}
