package io.github.williamjesusdev.grupojsa.core.rest.dto.responses;

import io.github.williamjesusdev.grupojsa.empresa.rest.dto.responses.ResumoEmpresaResponseDTO;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CidadeResponseDTO {
    private Integer id;
    private String nome;
    private String estado;

    private List<ResumoEmpresaResponseDTO> empresas;
}
