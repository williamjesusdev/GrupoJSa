package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Imovel;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.ImovelRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.ImovelResponseDTO;

import java.util.List;

public interface ImovelService {
    List<ImovelResponseDTO> getImoveisByFilter(Imovel filter);

    ImovelResponseDTO getImovelById(Integer id);

    Imovel createImovel(ImovelRequestDTO imovelRequestDTO);
}
