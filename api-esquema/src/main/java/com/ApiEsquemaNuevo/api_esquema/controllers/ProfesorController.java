package com.ApiEsquemaNuevo.api_esquema.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiEsquemaNuevo.api_esquema.dtos.ProfesorRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.ProfesorResponseDto;
import com.ApiEsquemaNuevo.api_esquema.services.ProfesorService;

@RestController 
@RequestMapping("api/profesores")
public class ProfesorController {
    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping 
    public ResponseEntity<List<ProfesorResponseDto>> listar(){
        return ResponseEntity.ok(profesorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(profesorService.buscarPorId(id));
    }
    
    @GetMapping("/dni/{dni}")
    public ResponseEntity<ProfesorResponseDto> buscarPorDni(@PathVariable String dni){
        return ResponseEntity.ok(profesorService.buscarPorDni(dni));
    }

    @PostMapping
    public ResponseEntity<ProfesorResponseDto> crear(@RequestBody ProfesorRequestDto datos){
        ProfesorResponseDto creado = profesorService.crear(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ProfesorResponseDto> actualizar(
        @PathVariable Long id,
        @RequestBody ProfesorRequestDto datos) {
            ProfesorResponseDto actualizado = profesorService.actualizar(id, datos);
            return ResponseEntity.ok(actualizado);
        }

        @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        profesorService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

         @DeleteMapping ("/dni/{dni}")
    public ResponseEntity<Void> eliminarPorDni(@PathVariable String dni){
        profesorService.eliminarPorDni(dni);
        return ResponseEntity.noContent().build();
    }
}
