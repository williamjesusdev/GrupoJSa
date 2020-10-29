package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.core.domain.repository.CidadesRepository;
import io.github.williamjesusdev.grupojsa.core.domain.service.impl.AllBuildersImpl;
import io.github.williamjesusdev.grupojsa.core.exception.BusinessRuleException;
import io.github.williamjesusdev.grupojsa.core.exception.ResourceNotFoundException;
import io.github.williamjesusdev.grupojsa.empresa.domain.entity.Empresa;
import io.github.williamjesusdev.grupojsa.empresa.domain.repository.EmpresasRepository;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Imovel;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository.ImoveisRepository;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.ImovelService;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.ImovelRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.ImovelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImovelServiceImpl extends AllBuildersImpl implements ImovelService {
    @Autowired
    private ImoveisRepository imoveisRepository;
    @Autowired
    private CidadesRepository cidadesRepository;
    @Autowired
    private EmpresasRepository empresasRepository;

    @Override
    public List<ImovelResponseDTO> getImoveisByFilter(Imovel filter){
        ExampleMatcher matcher = ExampleMatcher
                                .matching()
                                .withIgnorePaths("id")
                                .withIgnoreCase()
                                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filter, matcher);

        List<Imovel> imoveis = imoveisRepository.findAll(example);

        return imoveis
                .stream()
                .map(this::buildToImovelResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ImovelResponseDTO getImovelById(Integer id){
        Imovel imovel = imoveisRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Imóvel não cadastrado"));

        return buildToImovelResponseDTO(imovel);
    }

    @Override
    public Imovel createImovel(ImovelRequestDTO imovelRequestDTO){
        Integer idCidade = imovelRequestDTO.getCidade();
        Integer idProprietario = imovelRequestDTO.getProprietario();

        Cidade cidade = cidadesRepository
                        .findById(idCidade)
                        .orElseThrow(() -> new BusinessRuleException("Código da cidade inválido: " + idCidade));

        Empresa proprietario = empresasRepository
                .findById(idProprietario)
                .orElseThrow(() -> new BusinessRuleException("Código proprietário inválido: " + idProprietario));

        Imovel imovel = new Imovel(imovelRequestDTO, cidade, proprietario);

        imovel.setContratos(new ArrayList<>());

        return imoveisRepository.save(imovel);
    }
}
