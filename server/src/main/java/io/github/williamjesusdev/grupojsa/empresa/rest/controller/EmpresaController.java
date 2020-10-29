package io.github.williamjesusdev.grupojsa.empresa.rest.controller;

import io.github.williamjesusdev.grupojsa.empresa.domain.entity.Empresa;
import io.github.williamjesusdev.grupojsa.empresa.domain.service.impl.EmpresaServiceImpl;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.requests.EmpresaRequestDTO;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.responses.EmpresaResponseDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaServiceImpl empresaService;

    @GetMapping
    public List<EmpresaResponseDTO> getEmpresasByFilter( EmpresaRequestDTO empresa){
        return empresaService.getEmpresasByFilter(empresa);
    }

    @GetMapping("{id}")
    public EmpresaResponseDTO getEmpresaById(@PathVariable Integer id){
        return empresaService.getEmpresaById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Empresa createEmpresa(@RequestBody @Valid EmpresaRequestDTO empresaRequestDTO){
        return empresaService.createEmpresa(empresaRequestDTO);
    }
}
