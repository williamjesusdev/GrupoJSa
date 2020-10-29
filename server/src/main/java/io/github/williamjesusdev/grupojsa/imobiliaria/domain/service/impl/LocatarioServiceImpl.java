package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.core.domain.repository.CidadesRepository;
import io.github.williamjesusdev.grupojsa.core.domain.service.impl.AllBuildersImpl;
import io.github.williamjesusdev.grupojsa.core.exception.BusinessRuleException;
import io.github.williamjesusdev.grupojsa.core.exception.ResourceNotFoundException;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Locatario;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository.LocatariosRepository;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.LocatarioService;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.LocatarioRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.LocatarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocatarioServiceImpl extends AllBuildersImpl implements LocatarioService {
    @Autowired
    private LocatariosRepository locatariosRepository;
    @Autowired
    private CidadesRepository cidadesRepository;

    @Override
    public List<LocatarioResponseDTO> getLocatariosByFilter(Locatario filter){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filter, matcher);

        List<Locatario> locatarios = locatariosRepository.findAll(example);

        return  locatarios
                .stream()
                .map(this::buildToLocatarioResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LocatarioResponseDTO getLocatarioById(Integer id){
        Locatario locatario = locatariosRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Locatario não cadastrada"));
        return buildToLocatarioResponseDTO(locatario);
    }

    @Override
    public Locatario createLocatario(LocatarioRequestDTO locatarioDTO) {
        Integer idCidade = locatarioDTO.getCidade();
        Cidade cidade = cidadesRepository
                .findById(idCidade)
                .orElseThrow(
                        () -> new BusinessRuleException("Código da cidade inválido: " + idCidade));

        Locatario locatario = new Locatario(locatarioDTO, cidade);

        locatario.setContratos(new ArrayList<>());

        return locatariosRepository.save(locatario);
    }

}
