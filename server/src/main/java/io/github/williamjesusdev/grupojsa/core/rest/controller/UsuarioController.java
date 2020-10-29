package io.github.williamjesusdev.grupojsa.core.rest.controller;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Usuario;
import io.github.williamjesusdev.grupojsa.core.domain.service.impl.UsuarioServiceImpl;
import io.github.williamjesusdev.grupojsa.core.exception.SenhaInvalidaException;
import io.github.williamjesusdev.grupojsa.core.rest.dto.requests.CredenciaisRequestDTO;
import io.github.williamjesusdev.grupojsa.core.rest.dto.requests.UsuarioRequestoDTO;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.TokenDTO;
import io.github.williamjesusdev.grupojsa.core.security.jwt.JwtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/usuarios")
@Api(tags = "Autenticação")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUsuario(@RequestBody @Valid UsuarioRequestoDTO usuarioRequestoDTO ){
        String senhaCriptografada = passwordEncoder.encode(usuarioRequestoDTO.getSenha());
        Usuario usuario = Usuario
                .builder()
                .login(usuarioRequestoDTO.getLogin())
                .senha(senhaCriptografada)
                .admin(usuarioRequestoDTO.isAdmin())
                .build();

        return usuarioService.createUsuario(usuario);
    }

    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody CredenciaisRequestDTO credenciais){
        try{
            Usuario usuario = Usuario.builder()
                    .login(credenciais.getLogin())
                    .senha(credenciais.getSenha()).build();
            UserDetails usuarioAutenticado = usuarioService.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getLogin(), token);
        } catch (UsernameNotFoundException | SenhaInvalidaException e ){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}

