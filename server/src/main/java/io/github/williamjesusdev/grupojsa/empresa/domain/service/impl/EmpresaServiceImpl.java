package io.github.williamjesusdev.grupojsa.empresa.domain.service.impl;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.core.domain.repository.CidadesRepository;
import io.github.williamjesusdev.grupojsa.core.domain.service.impl.AllBuildersImpl;
import io.github.williamjesusdev.grupojsa.core.exception.BusinessRuleException;
import io.github.williamjesusdev.grupojsa.core.exception.ResourceNotFoundException;
import io.github.williamjesusdev.grupojsa.empresa.domain.entity.Empresa;
import io.github.williamjesusdev.grupojsa.empresa.domain.repository.EmpresasRepository;
import io.github.williamjesusdev.grupojsa.empresa.domain.service.EmpresaService;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.requests.EmpresaRequestDTO;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.responses.EmpresaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl extends AllBuildersImpl implements EmpresaService {
    @Autowired
    private EmpresasRepository empresasRepository;
    @Autowired
    private CidadesRepository cidadesRepository;

    @Override
    public List<EmpresaResponseDTO> getEmpresasByFilter(EmpresaRequestDTO empresaRequestDTO){
        Empresa filter = new Empresa(empresaRequestDTO);
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filter, matcher);

        List<Empresa> empresas = empresasRepository.findAll(example);

        return  empresas
                .stream()
                .map(this::buildToEmpresaResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmpresaResponseDTO getEmpresaById(Integer id){
        Empresa empresa = empresasRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Empresa não cadastrada"));
        return buildToEmpresaResponseDTO(empresa);
    }

    @Override
    public Empresa createEmpresa(@RequestBody EmpresaRequestDTO empresaRequestDTO){
        Integer idCidade = empresaRequestDTO.getCidade();
        Cidade cidade = cidadesRepository
                .findById(idCidade)
                .orElseThrow(
                        () -> new BusinessRuleException("Código da cidade inválido: "+ idCidade));

        Empresa empresa = new Empresa(empresaRequestDTO, cidade);

        empresa.setImoveis(new ArrayList<>());

        return empresasRepository.save(empresa);
    }

}
