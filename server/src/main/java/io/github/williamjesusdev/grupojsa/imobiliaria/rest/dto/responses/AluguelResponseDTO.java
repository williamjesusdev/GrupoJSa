package io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AluguelResponseDTO {

    private Long id;

    private Long  recibo;

    private LocalDate data;

    private BigDecimal valor;

    private BigDecimal iptu;

    private BigDecimal seguro;

    private BigDecimal multa;

    private BigDecimal outros;

    private BigDecimal desconto;

    private BigDecimal total;

    private String status;

    private ResumoContratoResponseDTO contrato;
}
