package io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImovelRequestDTO {

    @Size(max = 30)
    private String matricula;

    @NotNull(message = "Valor é obrigatório")
    private BigDecimal valor;

    @NotNull(message = "Alugado é obrigatório")
    private Boolean alugado;

    @NotNull(message = "Obra é obrigatório")
    private Boolean obra;

    @Size(max = 60)
    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @Size(max = 10)
    @NotBlank(message = "Número é obrigatório (Default: S/N)")
    private String numero;

    @Size(max = 30)
    @NotBlank(message = "Bairro é obrigatório")
    private String bairro;

    private String complemento;

    @Size(min = 8, max = 8)
    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    @NotBlank(message = "Cod cidade é obrigatório")
    private Integer cidade;

    @NotBlank(message = "Cod proprietário é obrigatório")
    private Integer proprietario;
}

