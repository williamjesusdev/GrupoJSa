package io.github.williamjesusdev.grupojsa.imobiliaria.rest.controller;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Locatario;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl.LocatarioServiceImpl;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.LocatarioRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.LocatarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/locatarios")
public class LocatarioController {
    @Autowired
    private LocatarioServiceImpl locatarioService;

    @GetMapping
    public List<LocatarioResponseDTO> getLocatariosByFilter(Locatario locatario){
        return locatarioService.getLocatariosByFilter(locatario);
    }

    @GetMapping("{id}")
    public LocatarioResponseDTO getLocatarioById(@PathVariable Integer id){
        return locatarioService.getLocatarioById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Locatario createLocatario(@RequestBody @Valid LocatarioRequestDTO locatarioDTO){
       return locatarioService.createLocatario(locatarioDTO);
    }
}
