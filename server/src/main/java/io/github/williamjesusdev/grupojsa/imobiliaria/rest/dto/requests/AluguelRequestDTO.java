package io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AluguelRequestDTO {

    @NotNull(message = "Recibo é obrigatório")
    private Long  recibo;

    @NotNull(message = "Data é obrigatória")
    private LocalDate data;

    @NotNull(message = "Valor é obrigatório")
    private BigDecimal valor;

    @NotNull(message = "Iptu é obrigatório")
    private BigDecimal iptu;

    @NotNull(message = "Seguro é obrigatório")
    private BigDecimal seguro;

    @NotNull(message = "Multa é obrigatório")
    private BigDecimal multa;

    @NotNull(message = "Outros é obrigatório")
    private BigDecimal outros;

    @NotNull(message = "Desconto é obrigatório")
    private BigDecimal desconto;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Status é Obrigatório")
    private String status;

    @NotNull(message = "Cód do contrato é obrigatório")
    private Integer contrato;
}
