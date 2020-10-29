package io.github.williamjesusdev.grupojsa.core.rest.controller;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.core.domain.service.impl.CidadeServiceImpl;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.CidadeResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/cidades")
@Api(tags = "Cidades")
public class CidadeController {
    @Autowired
    private CidadeServiceImpl cidadeService;

    @GetMapping
    public List<CidadeResponseDTO> getAllCidades(){
        return cidadeService.getAllCidades();
    }

    @GetMapping("{id}")
    public CidadeResponseDTO getCidadeById(@PathVariable Integer id){
        return cidadeService.getCidadeById(id);
    }

    @PostMapping
    public CidadeResponseDTO createCidade(@RequestBody @Valid Cidade cidade){
        return cidadeService.createCidade(cidade);
    }
}