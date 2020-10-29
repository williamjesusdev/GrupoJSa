package io.github.williamjesusdev.grupojsa.empresa.domain.service;

import io.github.williamjesusdev.grupojsa.empresa.domain.entity.Empresa;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.requests.EmpresaRequestDTO;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.responses.EmpresaResponseDTO;

import java.util.List;

public interface EmpresaService {
    List<EmpresaResponseDTO> getEmpresasByFilter(EmpresaRequestDTO empresaRequestDTO);

    EmpresaResponseDTO getEmpresaById(Integer id);

    Empresa createEmpresa(EmpresaRequestDTO empresaRequestDTO);
}
