package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiEsquemaNuevo.api_esquema.dtos.DepartamentoRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.DepartamentoResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Departamento;
import com.ApiEsquemaNuevo.api_esquema.exceptions.CodigoAlreadyExistisException;
import com.ApiEsquemaNuevo.api_esquema.exceptions.DepartamentoNotFoundException;
import com.ApiEsquemaNuevo.api_esquema.repositories.DepartamentoRepository;
import com.ApiEsquemaNuevo.api_esquema.services.DepartamentoService;



@Service 
public class DepartamentoServiceImpl implements DepartamentoService{
    
    private final DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    @Transactional  
    public DepartamentoResponseDto crear(DepartamentoRequestDto datos) {

        if(departamentoRepository.existsByCodigo(datos.codigo())) {
            throw new CodigoAlreadyExistisException("Ya existe un departamento con el código: " + datos.codigo());
        }
        
        Departamento departamento = new Departamento();
       
        departamento.setCodigo(datos.codigo());
        departamento.setNombre(datos.nombre());
        departamento.setDescripcion(datos.descripcion());
        departamento.setTelefono(datos.telefono());

        Departamento guardado = departamentoRepository.save(departamento);

        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional(readOnly = true) 
    public List<DepartamentoResponseDto> listar(){
        List<Departamento> departamentos = departamentoRepository.findAll();
        
        return departamentos.stream()
            .map(this::mapToResponseDto)
            .toList();
    }

    @Override 
    @Transactional(readOnly = true)
    public DepartamentoResponseDto buscarPorId(Long id){
        Departamento departamento = departamentoRepository.findById(id)
        .orElseThrow(() -> new DepartamentoNotFoundException("Departamento no encontrado con id:" + id));
        
        return mapToResponseDto(departamento);
    }

    @Override 
    @Transactional(readOnly = true)
    public DepartamentoResponseDto buscarPorCodigo(String codigo){
        Departamento departamento = departamentoRepository.findByCodigo(codigo)
        .orElseThrow(() -> new DepartamentoNotFoundException("Departamento no encontrado con codigo: " + codigo));

        return mapToResponseDto(departamento);
    }

    @Override 
    @Transactional 
        public DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto datos){

            Departamento departamento = departamentoRepository.findById(id)
            .orElseThrow(() -> new DepartamentoNotFoundException("Departamento no encontrado con id: " + id));

             if(!departamento.getCodigo().equalsIgnoreCase(datos.codigo()) && departamentoRepository.existsByCodigo(datos.codigo())) {
                throw new CodigoAlreadyExistisException("Ya existe un departamento con el código: " + datos.codigo());
            }

            departamento.setCodigo(datos.codigo());
            departamento.setNombre(datos.nombre());
            departamento.setDescripcion(datos.descripcion());
            departamento.setTelefono(datos.telefono());

            Departamento actualizado = departamentoRepository.save(departamento);

            return mapToResponseDto(actualizado);
            
        }

    @Override
    @Transactional 
    public void eliminar(Long id){
        Departamento departamento = departamentoRepository.findById(id)
        .orElseThrow(() -> new DepartamentoNotFoundException("Departamento no encontrado con id: " + id));

        departamentoRepository.delete(departamento);
    }

    private DepartamentoResponseDto mapToResponseDto(Departamento departamento){

        return new DepartamentoResponseDto(
            departamento.getIdDepartamento(),
            departamento.getCodigo(),
            departamento.getNombre(),
            departamento.getDescripcion(),
            departamento.getTelefono()
        );
    }
}
