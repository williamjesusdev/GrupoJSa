package io.github.williamjesusdev.grupojsa.imobiliaria.rest.controller;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Imovel;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl.ImovelServiceImpl;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.ImovelRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.ImovelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/imoveis")
public class ImovelController {
    @Autowired
    private ImovelServiceImpl imovelService;

    @GetMapping
    public List<ImovelResponseDTO> getImoveisByFilter(Imovel imovel){
        return imovelService.getImoveisByFilter(imovel);
    }

    @GetMapping("{id}")
    public ImovelResponseDTO getImovelById(@PathVariable Integer id){
       return imovelService.getImovelById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Imovel createImovel(@RequestBody @Valid ImovelRequestDTO imovelRequestDTO){
       return imovelService.createImovel(imovelRequestDTO);
    }
}
