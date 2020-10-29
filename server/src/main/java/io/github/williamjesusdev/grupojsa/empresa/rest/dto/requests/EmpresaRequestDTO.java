package io.github.williamjesusdev.grupojsa.empresa.rest.dto.requests;

import io.github.williamjesusdev.grupojsa.core.domain.annotation.CpfCnpj;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequestDTO {

    @Size(max = 80)
    @NotBlank(message = "Razão é obrigatória")
    private String razao;

    @Size(max = 50)
    private String fantasia;

    @Size(max = 15)
    @CpfCnpj
    @NotBlank(message = "CJPJ é obrigatório")
    private String cnpj;

    @Size(max = 15)
    @NotBlank(message = "Inscrição é obrigatório (Default: ISENTO)")
    private String ie;

    @Size(min = 10, max = 11)
    private String telefone;

    @Size(max = 50)
    private String email;

    @Size(max = 60)
    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @Size(max = 10)
    @NotBlank(message = "Número é obrigatório (Default: S/N)")
    private String numero;

    @Size(max = 30)
    @NotBlank(message = "Bairro é obrigatório")
    private String bairro;

    @Size(max = 30)
    private String complemento;

    @Size(min = 8, max = 8)
    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    @NotBlank(message = "Cod cidade é obrigatório")
    private Integer cidade;
}

