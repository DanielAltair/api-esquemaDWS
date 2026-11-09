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

import com.ApiEsquemaNuevo.api_esquema.dtos.EstadoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.EstadoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.services.EstadoService;


@RestController 
@RequestMapping("api/estados")
public class EstadoController {
    private final EstadoService estadoservice;

    public EstadoController(EstadoService estadoservice) {
        this.estadoservice = estadoservice;
    }


    @GetMapping 
    public ResponseEntity<List<EstadoResponseDto>> listar(){
        return ResponseEntity.ok(estadoservice.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(estadoservice.buscarPorId(id));
    }
    

    @PostMapping
    public ResponseEntity<EstadoResponseDto> crear(@RequestBody EstadoRequestDto datos){
        EstadoResponseDto creado = estadoservice.crear(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<EstadoResponseDto> actualizar(
        @PathVariable Long id,
        @RequestBody EstadoRequestDto datos) {
           EstadoResponseDto actualizado = estadoservice.actualizar(id, datos);
            return ResponseEntity.ok(actualizado);
        }

        @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
       estadoservice.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
