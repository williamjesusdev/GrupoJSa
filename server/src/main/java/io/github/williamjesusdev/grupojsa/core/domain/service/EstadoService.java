package io.github.williamjesusdev.grupojsa.core.domain.service;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Estado;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.EstadoResponseDTO;

import java.util.List;

public interface EstadoService {
    List<EstadoResponseDTO> getAllEstados();

    EstadoResponseDTO getEstadoById(Integer id);

    EstadoResponseDTO createEstado(Estado estado);
}
