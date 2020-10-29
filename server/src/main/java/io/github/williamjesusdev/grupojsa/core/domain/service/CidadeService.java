package io.github.williamjesusdev.grupojsa.core.domain.service;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.CidadeResponseDTO;

import java.util.List;

public interface CidadeService {
    List<CidadeResponseDTO> getAllCidades();

    CidadeResponseDTO getCidadeById(Integer id);

    CidadeResponseDTO createCidade(Cidade cidade);
}
