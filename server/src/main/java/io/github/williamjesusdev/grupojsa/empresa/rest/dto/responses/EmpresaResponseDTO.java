package io.github.williamjesusdev.grupojsa.empresa.rest.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.CidadeResponseDTO;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaResponseDTO {
    private Integer id;
    private String razao;
    private String fantasia;
    private String cnpj;
    private String ie;
    private String telefone;
    private String email;
    private String endereco;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;

    @JsonIgnoreProperties(value = {"empresas"})
    private CidadeResponseDTO cidade;
}
