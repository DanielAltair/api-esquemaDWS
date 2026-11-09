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

import com.ApiEsquemaNuevo.api_esquema.dtos.CursoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.CursoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.services.CursoService;

@RestController 
@RequestMapping ("api/cusos")
public class CursoController {
    private final CursoService cursoservice;

    public CursoController(CursoService cursoservice) {
        this.cursoservice = cursoservice;
    }

     @GetMapping 
    public ResponseEntity<List<CursoResponseDto>> listar(){
        return ResponseEntity.ok(cursoservice.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(cursoservice.buscarPorID(id));
    }

    @GetMapping("/diminutivo/{diminutivo}")
    public ResponseEntity<CursoResponseDto> buscarPorDiminutivo(@PathVariable String diminutivo){
        return ResponseEntity.ok(cursoservice.buscarPorDiminutivo( diminutivo));
    }

    @PostMapping
    public ResponseEntity<CursoResponseDto> crear(@RequestBody CursoRequestDto datos){
        CursoResponseDto creado = cursoservice.crear(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<CursoResponseDto> actualizar(@PathVariable Long id, @RequestBody CursoRequestDto datos) {
            CursoResponseDto actualizado = cursoservice.actualizar(id, datos);
            return ResponseEntity.ok(actualizado);
        }

          @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        cursoservice.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

           @DeleteMapping ("/diminutivo/{diminutivo}")
    public ResponseEntity<Void> eliminarPorDiminutivo(@PathVariable String diminutivo){
        cursoservice.eliminarPorDiminutivo(diminutivo);
        return ResponseEntity.noContent().build();
    }
}
