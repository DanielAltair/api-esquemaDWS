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

import com.ApiEsquemaNuevo.api_esquema.dtos.FamiliaRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.FamiliaResponseDto;
import com.ApiEsquemaNuevo.api_esquema.services.FamiliaService;

@RestController
@RequestMapping("api/familias")
public class FamiliaController {
    private final FamiliaService familiaService;

    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @GetMapping
    public ResponseEntity<List<FamiliaResponseDto>> listar() {
        return ResponseEntity.ok(familiaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(familiaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<FamiliaResponseDto> crear(@RequestBody FamiliaRequestDto datos) {
        FamiliaResponseDto creada = familiaService.crear(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody FamiliaRequestDto datos) {
        return ResponseEntity.ok(familiaService.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        familiaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
