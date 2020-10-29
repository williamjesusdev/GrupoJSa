package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl;

import io.github.williamjesusdev.grupojsa.core.domain.service.impl.AllBuildersImpl;
import io.github.williamjesusdev.grupojsa.core.exception.BusinessRuleException;
import io.github.williamjesusdev.grupojsa.core.exception.ResourceNotFoundException;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Contrato;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Imovel;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Locatario;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository.ContratosRepository;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository.ImoveisRepository;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository.LocatariosRepository;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.ContratoService;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.ContratoRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.ContratoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoServiceImpl extends AllBuildersImpl implements ContratoService {
    @Autowired
    private ContratosRepository contratosRepository;
    @Autowired
    private ImoveisRepository imoveisRepository;
    @Autowired
    private LocatariosRepository locatariosRepository;


    @Override
    public List<ContratoResponseDTO> getAllContratos(){
        List<Contrato> contratos = contratosRepository.findAll();

        return contratos
                .stream()
                .map(this::buildToContratoResponseDTO)
                .collect(Collectors.toList());
    }



    @Override
    public ContratoResponseDTO getContratosById(Integer id){
        Contrato contrato = contratosRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contrato não cadastrado"));

        return buildToContratoResponseDTO(contrato);
    }

    @Override
    public Contrato createContrato(ContratoRequestDTO contratoRequestDTO) {
        Integer imovelId = contratoRequestDTO.getImovel();
        Integer locatarioId = contratoRequestDTO.getLocatario();

        Imovel imovel = imoveisRepository
                .findById(imovelId)
                .orElseThrow(() -> new BusinessRuleException("Código de imóvel inválido: " + imovelId));

        Locatario locatario = locatariosRepository
                .findById(locatarioId)
                .orElseThrow(() -> new BusinessRuleException("Código de locatário inválido: " + locatarioId));

        Contrato contratoSalvo = new Contrato(contratoRequestDTO, imovel, locatario);

        contratoSalvo.setAlugueis(new ArrayList<>());

        return contratosRepository.save(contratoSalvo);
    }
}
