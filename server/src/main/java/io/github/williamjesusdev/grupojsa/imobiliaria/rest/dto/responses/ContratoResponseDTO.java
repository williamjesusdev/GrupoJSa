package io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContratoResponseDTO {
    private Integer id;

    private LocalDate data;

    private BigDecimal valor;

    private LocalDate validade;

    private ResumoLocatarioResponseDTO locatario;

    private ResumoImovelResponseDTO imovel;
}
