package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ApiEsquemaNuevo.api_esquema.dtos.DepartamentoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.DepartamentoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Departamento;
import com.ApiEsquemaNuevo.api_esquema.repositories.DepartamentoRepository;
import com.ApiEsquemaNuevo.api_esquema.services.DepartamentoService;

@Service 
public class DepartamentoServiceImpl implements DepartamentoService{
    
    private final DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override 
    public DepartamentoResponseDto crear(DepartamentoRequestDto datos) {
        
        Departamento departamento = new Departamento();
       
        departamento.setCodigo(datos.codigo());
        departamento.setNombre(datos.nombre());
        departamento.setDescripcion(datos.descripcion());
        departamento.setTelefono(datos.telefono());

        Departamento guardado = departamentoRepository.save(departamento);

        return new DepartamentoResponseDto(
            guardado.getIdDepartamento(),
            guardado.getCodigo(),
            guardado.getNombre(),
            guardado.getDescripcion(),
            guardado.getTelefono()
        );
    }

    @Override 
    public List<DepartamentoResponseDto> listar(){
        List<Departamento> departamentos = departamentoRepository.findAll();
        
        return departamentos.stream()
            .map(departamento -> new DepartamentoResponseDto(
                departamento.getIdDepartamento(),
                departamento.getCodigo(),
                departamento.getNombre(),
                departamento.getDescripcion(),
                departamento.getTelefono()
            ))
            .toList();
    }

    @Override 
    public DepartamentoResponseDto buscarPorId(Long id){
        Departamento departamento = departamentoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Departamento no encontrado con id:" + id));
        
        return new DepartamentoResponseDto(
            departamento.getIdDepartamento(),
            departamento.getCodigo(),
            departamento.getNombre(),
            departamento.getDescripcion(),
            departamento.getTelefono() 
        );
    }

    @Override 
    public DepartamentoResponseDto buscarPorCodigo(String codigo){
        Departamento departamento = departamentoRepository.findByCodigo(codigo)
        .orElseThrow(() -> new RuntimeException("Departamento no encontrado con codigo: " + codigo));

        return new DepartamentoResponseDto(
            departamento.getIdDepartamento(),
            departamento.getCodigo(),
            departamento.getNombre(),
            departamento.getDescripcion(),
            departamento.getTelefono()
        );
    }

    @Override 
        public DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto datos){
            Departamento departamento = departamentoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Departamento no encontrado con id: " + id));

            departamento.setCodigo(datos.codigo());
            departamento.setNombre(datos.nombre());
            departamento.setDescripcion(datos.descripcion());
            departamento.setTelefono(datos.telefono());

            Departamento actualizado = departamentoRepository.save(departamento);

            return new DepartamentoResponseDto(
                actualizado.getIdDepartamento(),
                actualizado.getCodigo(),
                actualizado.getNombre(),
                actualizado.getDescripcion(),
                actualizado.getTelefono()
            );
        }

    @Override
    public void eliminar(Long id){
        Departamento departamento = departamentoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Departamento no encontrado con id: " + id));

        departamentoRepository.delete(departamento);
    }
}
