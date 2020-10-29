package io.github.williamjesusdev.grupojsa.core.rest.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EstadoResponseDTO {
    private Integer id;
    private String nome;
    private String sigla;

    @JsonIgnoreProperties(value = {"empresas"})
    private List<CidadeResponseDTO> cidades;
}
