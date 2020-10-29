package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Locatario;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.LocatarioRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.LocatarioResponseDTO;

import java.util.List;

public interface LocatarioService {
    List<LocatarioResponseDTO> getLocatariosByFilter(Locatario filter);

    LocatarioResponseDTO getLocatarioById(Integer id);

    Locatario createLocatario(LocatarioRequestDTO locatarioDTO);
}
