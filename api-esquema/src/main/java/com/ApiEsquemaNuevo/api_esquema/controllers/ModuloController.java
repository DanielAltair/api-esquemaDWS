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

import com.ApiEsquemaNuevo.api_esquema.dtos.ModuloRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.ModuloResponseDto;
import com.ApiEsquemaNuevo.api_esquema.services.ModuloService;

@RestController 
@RequestMapping("api/modulos")
public class ModuloController {
    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }
    

    @GetMapping 
    public ResponseEntity<List<ModuloResponseDto>> listar(){
        return ResponseEntity.ok(moduloService.listar());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ModuloResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(moduloService.buscarPorId(id));
    }

    @GetMapping ("/codigo/{codigo}")
    public ResponseEntity<ModuloResponseDto> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(moduloService.buscarPorCodigo(codigo));
    }

    @GetMapping ("/diminutivo/{diminutivo}")
    public ResponseEntity<ModuloResponseDto> buscarPorDiminutivo(@PathVariable String diminutivo) {
        return ResponseEntity.ok(moduloService.buscarPorDiminutivo(diminutivo));
    }

    @PostMapping
    public ResponseEntity<ModuloResponseDto> crear(@RequestBody ModuloRequestDto datos){
        ModuloResponseDto creado = moduloService.crear(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado); //Porque es una creación, se devuelve el código 201 (CREATED) con el cuerpo (body).
    }
    
    @PutMapping ("/{id}")
    public ResponseEntity<ModuloResponseDto> actualizarPorId(@PathVariable Long id, @RequestBody ModuloRequestDto datos) {
        ModuloResponseDto actualizado = moduloService.actualizarPorId(id, datos);
        return ResponseEntity.ok(actualizado);
    }

    @PutMapping ("/codigo/{codigo}")
    public ResponseEntity<ModuloResponseDto> actualizarPorCodigo(@PathVariable String codigo, @RequestBody ModuloRequestDto datos) {
        ModuloResponseDto actualizado = moduloService.actualizarPorCodigo(codigo, datos);
        return ResponseEntity.ok(actualizado);
    }

    @PutMapping ("/diminutivo/{diminutivo}")
    public ResponseEntity<ModuloResponseDto> actualizarPorDiminutivo(@PathVariable String diminutivo, @RequestBody ModuloRequestDto datos) {
        ModuloResponseDto actualizado = moduloService.actualizarPorDiminutivo(diminutivo, datos);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        moduloService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping ("/codigo/{codigo}")
    public ResponseEntity<Void> eliminarPorCodigo(@PathVariable String codigo){
        moduloService.eliminarPorCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping ("/diminutivo/{diminutivo}")
    public ResponseEntity<Void> eliminarPorDiminutivo(@PathVariable String diminutivo){
        moduloService.eliminarPorDiminutivo(diminutivo);
        return ResponseEntity.noContent().build();
    }
}