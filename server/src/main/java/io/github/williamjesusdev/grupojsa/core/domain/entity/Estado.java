package io.github.williamjesusdev.grupojsa.core.domain.entity;

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
@Table(name="estados")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome é Obrigatório")
    @Size(min = 5, max = 50)
    @Column(nullable = false, length = 50)
    private String nome;

    @NotBlank(message = "Sigla é Obrigatório")
    @Size(min = 2, max = 2)
    @Column(nullable = false, length = 2)
    private String sigla;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cidade> cidades;
}
