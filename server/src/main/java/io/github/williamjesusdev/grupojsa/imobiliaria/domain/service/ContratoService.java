package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Contrato;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.ContratoRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.ContratoResponseDTO;

import java.util.List;

public interface ContratoService {
    List<ContratoResponseDTO> getAllContratos();

    ContratoResponseDTO getContratosById(Integer id);

    Contrato createContrato(ContratoRequestDTO contratoRequestDTO);
}
