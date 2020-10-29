package io.github.williamjesusdev.grupojsa.imobiliaria.rest.controller;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl.DimobServiceImpl;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.DimobTotalByMonthResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/dimob")
public class DimobController {
    @Autowired
    private DimobServiceImpl dimobService;

    @GetMapping("/mensal/{ano}")
    public Map<ArrayList<String>, List<DimobTotalByMonthResponseDTO>> getDimobByMesGroupEmpresa(@PathVariable Integer ano){
        return dimobService.getDimobByMesGroupEmpresa(ano);
    }

    @GetMapping("/mensal")
    public Map<ArrayList<String>, List<DimobTotalByMonthResponseDTO>> getDimobUltimoMesGroupEmpresa(){
        return dimobService.getDimobUltimoMesGroupEmpresa();
    }

}