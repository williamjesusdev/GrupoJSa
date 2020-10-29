package io.github.williamjesusdev.grupojsa.core.domain.service.impl;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.core.domain.entity.Estado;
import io.github.williamjesusdev.grupojsa.core.domain.repository.CidadesRepository;
import io.github.williamjesusdev.grupojsa.core.domain.repository.EstadosRepository;
import io.github.williamjesusdev.grupojsa.core.domain.service.CidadeService;
import io.github.williamjesusdev.grupojsa.core.exception.ResourceNotFoundException;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.CidadeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeServiceImpl extends AllBuildersImpl implements CidadeService {
    @Autowired
    private CidadesRepository cidadesRepository;

    @Autowired
    private EstadosRepository estadosRepository;

    @Override
    public List<CidadeResponseDTO> getAllCidades(){
        List<Cidade> cidades = cidadesRepository.findAll();

        return cidades
                .stream()
                .map(this::buildToCidadeResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CidadeResponseDTO getCidadeById(Integer id){
        Cidade cidade = cidadesRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada"));

        return buildToCidadeResponseDTO(cidade);
    }

    @Override
    public CidadeResponseDTO createCidade(Cidade cidade){
        Estado estado = estadosRepository
                .findById(cidade.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Estado não encontrado"));
        cidade.setEstado(estado);
        Cidade cidadeSalva = cidadesRepository.save(cidade);
        cidadeSalva.setEmpresas(new ArrayList<>());

        return buildToCidadeResponseDTO(cidadeSalva);
    }
}