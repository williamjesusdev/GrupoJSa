package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service;

import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.DimobTotalByMonthResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DimobService {
    Map<ArrayList<String>, List<DimobTotalByMonthResponseDTO>> getDimobByMesGroupEmpresa(Integer ano);

    Map<ArrayList<String>, List<DimobTotalByMonthResponseDTO>> getDimobUltimoMesGroupEmpresa();

}
