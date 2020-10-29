package io.github.williamjesusdev.grupojsa.core.rest.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestoDTO {

    @NotBlank(message = "Login é obrigatório")
    private String login;

    @NotEmpty(message = "Senha é obrigatório")
    private String senha;

    private boolean admin;
}
