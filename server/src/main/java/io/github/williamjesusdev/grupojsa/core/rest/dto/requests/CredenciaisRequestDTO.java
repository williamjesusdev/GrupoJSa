package io.github.williamjesusdev.grupojsa.core.rest.dto.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredenciaisRequestDTO {
    private String login;
    private String senha;
}
