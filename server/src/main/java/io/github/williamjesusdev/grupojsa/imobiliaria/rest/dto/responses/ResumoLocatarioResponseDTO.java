package io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResumoLocatarioResponseDTO {
    private Integer id;
    private String razao;
    private String fantasia;
    private String cnpj;
}
