package io.github.williamjesusdev.grupojsa.core.domain.entity;

import io.github.williamjesusdev.grupojsa.empresa.domain.entity.Empresa;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Imovel;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Locatario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cidades")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome é Obrigatório")
    @Size(min = 4, max = 50)
    @Column(nullable = false, length = 50)
    private String nome;

    @NotBlank(message = "Código do Estado é Obrigatório")
    @ManyToOne
    @JoinColumn(name="estado_id")
    private Estado estado;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Empresa> empresas;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Imovel> imoveis;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Locatario> locatarios;
}