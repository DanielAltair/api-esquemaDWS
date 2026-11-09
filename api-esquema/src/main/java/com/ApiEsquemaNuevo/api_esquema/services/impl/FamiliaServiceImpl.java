package com.ApiEsquemaNuevo.api_esquema.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiEsquemaNuevo.api_esquema.dtos.FamiliaRequestDto;
import com.ApiEsquemaNuevo.api_esquema.dtos.FamiliaResponseDto;
import com.ApiEsquemaNuevo.api_esquema.entities.Familia;
import com.ApiEsquemaNuevo.api_esquema.repositories.FamiliaRepository;
import com.ApiEsquemaNuevo.api_esquema.services.FamiliaService;

@Service
public class FamiliaServiceImpl implements FamiliaService {
    private final FamiliaRepository familiaRepository;

    public FamiliaServiceImpl(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    @Override
    @Transactional
    public FamiliaResponseDto crear(FamiliaRequestDto datos) {
        Familia familia = new Familia();
        aplicarDatos(familia, datos);
        return mapToResponseDto(familiaRepository.save(familia));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FamiliaResponseDto> listar() {
        return familiaRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public FamiliaResponseDto buscarPorId(Long id) {
        Familia familia = familiaRepository.findById(id).orElseThrow();
        return mapToResponseDto(familia);
    }

    @Override
    @Transactional
    public FamiliaResponseDto actualizar(Long id, FamiliaRequestDto datos) {
        Familia familia = familiaRepository.findById(id).orElseThrow();
        aplicarDatos(familia, datos);
        return mapToResponseDto(familiaRepository.save(familia));
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        Familia familia = familiaRepository.findById(id).orElseThrow();
        familiaRepository.delete(familia);
    }

    private void aplicarDatos(Familia familia, FamiliaRequestDto datos) {
        familia.setNombrePadre(datos.nombrePadre());
        familia.setApellidosPadre(datos.apellidosPadre());
        familia.setEmailPadre(datos.emailPadre());
        familia.setTelefonoPadre(datos.telefonoPadre());
        familia.setDireccionPadre(datos.direccionPadre());
        familia.setCpPadre(datos.cpPadre());
        familia.setProvinciaPadre(datos.provinciaPadre());
        familia.setNombreMadre(datos.nombreMadre());
        familia.setApellidosMadre(datos.apellidosMadre());
        familia.setEmailMadre(datos.emailMadre());
        familia.setTelefonoMadre(datos.telefonoMadre());
        familia.setDireccionMadre(datos.direccionMadre());
        familia.setCpMadre(datos.cpMadre());
        familia.setProvinciaMadre(datos.provinciaMadre());
        familia.setSonSeparados(datos.sonSeparados());
        familia.setEsCompartida(datos.esCompartida());
        familia.setEsPadre(datos.esPadre());
        familia.setEsMadre(datos.esMadre());
    }

    private FamiliaResponseDto mapToResponseDto(Familia familia) {
        return new FamiliaResponseDto(
                familia.getIdFamilia(),
                familia.getNombrePadre(),
                familia.getApellidosPadre(),
                familia.getEmailPadre(),
                familia.getTelefonoPadre(),
                familia.getDireccionPadre(),
                familia.getCpPadre(),
                familia.getProvinciaPadre(),
                familia.getNombreMadre(),
                familia.getApellidosMadre(),
                familia.getEmailMadre(),
                familia.getTelefonoMadre(),
                familia.getDireccionMadre(),
                familia.getCpMadre(),
                familia.getProvinciaMadre(),
                familia.isSonSeparados(),
                familia.isEsCompartida(),
                familia.isEsPadre(),
                familia.isEsMadre());
    }
}
