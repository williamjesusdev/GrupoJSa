package io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContratoRequestDTO {

    @NotBlank(message = "Data é obrigatória")
    private LocalDate data;

    private BigDecimal valor;

    private LocalDate validade;

    @NotBlank(message = "Cód locatário é obrigatório")
    private Integer locatario;

    @NotBlank(message = "Cód imóvel é obrigatório")
    private Integer imovel;
}
