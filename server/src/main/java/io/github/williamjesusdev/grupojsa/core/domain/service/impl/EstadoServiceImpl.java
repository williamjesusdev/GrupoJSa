package io.github.williamjesusdev.grupojsa.core.domain.service.impl;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Estado;
import io.github.williamjesusdev.grupojsa.core.domain.repository.EstadosRepository;
import io.github.williamjesusdev.grupojsa.core.domain.service.EstadoService;
import io.github.williamjesusdev.grupojsa.core.exception.ResourceNotFoundException;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.EstadoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoServiceImpl extends AllBuildersImpl implements EstadoService {
    @Autowired
    private EstadosRepository estadosRepository;

    @Override
    public List<EstadoResponseDTO> getAllEstados(){
        List<Estado> estados = estadosRepository.findAll();

        return estados
                .stream()
                .map(this::buildToEstadoResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoResponseDTO getEstadoById(Integer id){
        Estado estado = estadosRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estado não encontrado"));

        return buildToEstadoResponseDTO(estado);
    }

    @Override
    public EstadoResponseDTO createEstado(Estado estado) {
        estado.setSigla(estado.getSigla().toUpperCase());
        Estado estadoSalvo = estadosRepository.save(estado);
        estadoSalvo.setCidades(new ArrayList<>());

        return buildToEstadoResponseDTO(estadoSalvo);
    }
}
