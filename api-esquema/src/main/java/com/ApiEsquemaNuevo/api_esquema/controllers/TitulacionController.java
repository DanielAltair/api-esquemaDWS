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

import com.ApiEsquemaNuevo.api_esquema.dtos.TitulacionRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.TitulacionResponseDto;
import com.ApiEsquemaNuevo.api_esquema.services.TitulacionService;

@RestController
@RequestMapping("api/titulaciones")
public class TitulacionController {
    private final TitulacionService titulacionService;

    public TitulacionController(TitulacionService titulacionService) {
        this.titulacionService = titulacionService;
    }

    @GetMapping
    public ResponseEntity<List<TitulacionResponseDto>> listar() {
        return ResponseEntity.ok(titulacionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(titulacionService.buscarPorId(id));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<TitulacionResponseDto> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(titulacionService.buscarPorCodigo(codigo));
    }

    @GetMapping("/diminutivo/{diminutivo}")
    public ResponseEntity<TitulacionResponseDto> buscarPorDiminutivo(@PathVariable String diminutivo) {
        return ResponseEntity.ok(titulacionService.buscarPorDiminutivo(diminutivo));
    }

    @PostMapping
    public ResponseEntity<TitulacionResponseDto> crear(@RequestBody TitulacionRequestDto datos) {
        TitulacionResponseDto creado = titulacionService.crear(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody TitulacionRequestDto datos) {
        return ResponseEntity.ok(titulacionService.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        titulacionService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/codigo/{codigo}")
    public ResponseEntity<Void> eliminarPorCodigo(@PathVariable String codigo) {
        titulacionService.eliminarPorCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/diminutivo/{diminutivo}")
    public ResponseEntity<Void> eliminarPorDiminutivo(@PathVariable String diminutivo) {
        titulacionService.eliminarPorDiminutivo(diminutivo);
        return ResponseEntity.noContent().build();
    }
}
