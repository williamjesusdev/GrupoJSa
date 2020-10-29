package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository.DimobRepository;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.DimobService;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.DimobTotalByMonthResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DimobServiceImpl implements DimobService {
    @Autowired
    private DimobRepository dimobRepository;

    @Override
    public Map<ArrayList<String>, List<DimobTotalByMonthResponseDTO>> getDimobByMesGroupEmpresa(Integer ano) {
        return dimobRepository
                .getDimobMensalByAno(ano)
                .stream()
                .collect(Collectors
                        .groupingBy(d -> {
                            return  new ArrayList<String>
                                    (Arrays.asList(d.getEmpresa(), Integer.toString(d.getIdEmpresa())));
                        })
                );
    }

    @Override
    public Map<ArrayList<String>, List<DimobTotalByMonthResponseDTO>> getDimobUltimoMesGroupEmpresa() {
       return dimobRepository
                .getDimobUltimoMes()
                .stream()
                .collect(Collectors
                        .groupingBy(d -> {
                            return  new ArrayList<String>
                                    (Arrays.asList(d.getEmpresa(), Integer.toString(d.getIdEmpresa())));
                        })
                );
    }
}
