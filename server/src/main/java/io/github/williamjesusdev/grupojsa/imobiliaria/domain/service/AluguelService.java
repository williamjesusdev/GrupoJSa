package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Aluguel;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.AluguelRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.AluguelResponseDTO;

import java.util.List;

public interface AluguelService {
    List<AluguelResponseDTO> getAllAlugueis();

    AluguelResponseDTO getAluguelById(Long id);

    List<AluguelResponseDTO> getAllAlugueisByRecibo(Long recibo);

    List<AluguelResponseDTO> getAllAlugueisByMes(Integer mes);

    Aluguel createAluguel(AluguelRequestDTO aluguelRequestDTO);
}
