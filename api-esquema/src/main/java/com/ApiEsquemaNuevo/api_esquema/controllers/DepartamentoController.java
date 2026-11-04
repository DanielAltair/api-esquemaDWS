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

import com.ApiEsquemaNuevo.api_esquema.dtos.DepartamentoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.DepartamentoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.services.DepartamentoService;

@RestController 
@RequestMapping("api/departamentos")
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping 
    public ResponseEntity<List<DepartamentoResponseDto>> listar(){
        return ResponseEntity.ok(departamentoService.listar());
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartamentoResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(departamentoService.buscarPorId(id));
    }

    @GetMapping ("codigo/{codigo}")
    public ResponseEntity<DepartamentoResponseDto> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(departamentoService.buscarPorCodigo(codigo));
    }

    @PostMapping 
    public ResponseEntity<DepartamentoResponseDto> crear(@RequestBody DepartamentoRequestDto datos){
        DepartamentoResponseDto creado = departamentoService.crear(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<DepartamentoResponseDto> actualizar(
        @PathVariable Long id,
        @RequestBody DepartamentoRequestDto datos) {
            DepartamentoResponseDto actualizado = departamentoService.actualizar(id, datos);
            return ResponseEntity.ok(actualizado);
        }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        departamentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
