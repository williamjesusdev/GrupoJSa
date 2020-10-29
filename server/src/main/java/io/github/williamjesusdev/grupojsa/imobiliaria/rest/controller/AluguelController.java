package io.github.williamjesusdev.grupojsa.imobiliaria.rest.controller;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Aluguel;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl.AluguelServiceImpl;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.AluguelRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.AluguelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/alugueis")
public class AluguelController {
    @Autowired
    private AluguelServiceImpl aluguelService;

    @GetMapping
    public List<AluguelResponseDTO> getAllAlugueis(){
       return aluguelService.getAllAlugueis();
    }

    @GetMapping("/{id}")
    public AluguelResponseDTO getAluguelById(@PathVariable Long id){
        return aluguelService.getAluguelById(id);
    }

    @GetMapping("/recibo/{recibo}")
    public List<AluguelResponseDTO> getAllAlugueisByRecibo(@PathVariable Long recibo){
        return aluguelService.getAllAlugueisByRecibo(recibo);
    }

    @GetMapping("/mensal/{mes}")
    public List<AluguelResponseDTO> getAllAlugueisByMes(@PathVariable Integer mes){
       return aluguelService.getAllAlugueisByMes(mes);
    }

    @PostMapping
    public Aluguel createAluguel(@RequestBody @Valid AluguelRequestDTO aluguelRequestDTO){
        return aluguelService.createAluguel(aluguelRequestDTO);
    }
}
