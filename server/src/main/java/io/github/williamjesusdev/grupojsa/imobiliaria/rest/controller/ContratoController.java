package io.github.williamjesusdev.grupojsa.imobiliaria.rest.controller;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Contrato;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl.ContratoServiceImpl;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.ContratoRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.ContratoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/contratos")
public class ContratoController {
    @Autowired
    private ContratoServiceImpl contratoService;

    @GetMapping
    public List<ContratoResponseDTO> getAllContratos(){
        return contratoService.getAllContratos();
    }

    @GetMapping("{id}")
    public ContratoResponseDTO getContratosByFilter(@PathVariable Integer id){
        return contratoService.getContratosById(id);
    }

    @PostMapping
    public Contrato createContrato(@RequestBody @Valid ContratoRequestDTO contratoRequestDTO){
        return contratoService.createContrato(contratoRequestDTO);
    }
}
