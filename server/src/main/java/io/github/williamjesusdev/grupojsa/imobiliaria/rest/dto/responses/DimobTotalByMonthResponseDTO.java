package io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DimobTotalByMonthResponseDTO {
    private Integer idEmpresa;

    private String empresa;

    private Integer mes;

    private BigDecimal total;
}
