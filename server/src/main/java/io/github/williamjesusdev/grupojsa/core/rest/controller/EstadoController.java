package io.github.williamjesusdev.grupojsa.core.rest.controller;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Estado;
import io.github.williamjesusdev.grupojsa.core.domain.service.impl.EstadoServiceImpl;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.EstadoResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/estados")
@Api(tags = "Estados")
public class EstadoController {
    @Autowired
    private EstadoServiceImpl estadoService;

    @GetMapping
    public List<EstadoResponseDTO> getAllEstados(){
        return estadoService.getAllEstados();
    }

    @GetMapping("{id}")
    public EstadoResponseDTO getEstadoById(@PathVariable Integer id){
        return estadoService.getEstadoById(id);
    }

    @PostMapping
    public EstadoResponseDTO createEstado(@RequestBody @Valid Estado estado){
        return estadoService.createEstado(estado);
    }
}
