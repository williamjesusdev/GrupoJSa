package io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.LocatarioRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="locatarios")
public class Locatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    private String razao;

    @Column(length = 50)
    private String fantasia;

    @Column(nullable = false,length = 15)
    private String cnpj;

    @Column(length = 15)
    private String ie;

    @Column(length = 11)
    private String telefone;

    @Column(length = 50)
    private String email;

    @Column(nullable=false, columnDefinition = "BIT DEFAULT 1")
    private Boolean ativo;

    @Column(length = 60)
    private String endereco;

    @Column(length = 10)
    private String numero;

    @Column(length = 30)
    private String bairro;

    @Column(length = 30)
    private String complemento;

    @Column(length = 8)
    private String cep;

    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;

    @OneToMany(mappedBy = "locatario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contrato> contratos;

    public Locatario(LocatarioRequestDTO locatarioRequestDTO, Cidade cidade) {
        this.razao = locatarioRequestDTO.getRazao();
        this.fantasia = locatarioRequestDTO.getFantasia();
        this.cnpj = locatarioRequestDTO.getCnpj();
        this.ie = locatarioRequestDTO.getIe();
        this.telefone = locatarioRequestDTO.getTelefone();
        this.email = locatarioRequestDTO.getEmail();
        this.endereco = locatarioRequestDTO.getEndereco();
        this.numero = locatarioRequestDTO.getNumero();
        this.bairro = locatarioRequestDTO.getBairro();
        this.complemento = locatarioRequestDTO.getComplemento();
        this.cep = locatarioRequestDTO.getCep();
        this.ativo = locatarioRequestDTO.getAtivo();

        this.cidade = cidade;
    }
}
