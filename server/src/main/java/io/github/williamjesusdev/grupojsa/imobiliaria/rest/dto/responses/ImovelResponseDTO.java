package io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.CidadeResponseDTO;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.responses.ResumoEmpresaResponseDTO;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImovelResponseDTO {
    private Integer id;
    private String matricula;
    private BigDecimal valor;
    private String endereco;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private Boolean alugado;
    private Boolean obra;

    @JsonIgnoreProperties(value = {"empresas"})
    private CidadeResponseDTO cidade;

    @JsonIgnoreProperties(value = {"cidade"})
    private ResumoEmpresaResponseDTO proprietario;
}
