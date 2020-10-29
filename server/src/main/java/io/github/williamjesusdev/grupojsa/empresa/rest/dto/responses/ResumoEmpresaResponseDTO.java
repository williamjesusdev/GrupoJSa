package io.github.williamjesusdev.grupojsa.empresa.rest.dto.responses;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResumoEmpresaResponseDTO {
    private Integer id;
    private String razao;
    private String fantasia;
    private String cnpj;
}
