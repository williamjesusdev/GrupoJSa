package io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResumoImovelResponseDTO {
    private Integer id;
    private BigDecimal valor;
    private String endereco;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
}
