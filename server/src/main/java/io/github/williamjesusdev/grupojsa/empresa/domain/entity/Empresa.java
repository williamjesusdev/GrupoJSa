package io.github.williamjesusdev.grupojsa.empresa.domain.entity;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.requests.EmpresaRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Imovel;
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
@Table(name="empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    private String razao;

    @Column(length = 50)
    private String fantasia;

    @Column(nullable = false,length = 15)
    private String cnpj;

    @Column(nullable = false,length = 15)
    private String ie;

    @Column(length = 11)
    private String telefone;

    @Column(length = 50)
    private String email;

    @Column(nullable = false,length = 60)
    private String endereco;

    @Column(nullable = false,length = 10)
    private String numero;

    @Column(nullable = false,length = 30)
    private String bairro;

    @Column(length = 30)
    private String complemento;

    @Column(nullable = false, length = 8)
    private String cep;

    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;

    @OneToMany(mappedBy = "proprietario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Imovel> imoveis;

    public Empresa(EmpresaRequestDTO empresaRequestDTO, Cidade cidade) {
        this.razao = empresaRequestDTO.getRazao();
        this.fantasia = empresaRequestDTO.getFantasia();
        this.cnpj = empresaRequestDTO.getCnpj();
        this.ie = empresaRequestDTO.getIe();
        this.telefone = empresaRequestDTO.getTelefone();
        this.email = empresaRequestDTO.getEmail();
        this.endereco = empresaRequestDTO.getEndereco();
        this.numero = empresaRequestDTO.getNumero();
        this.bairro = empresaRequestDTO.getBairro();
        this.complemento = empresaRequestDTO.getComplemento();
        this.cep = empresaRequestDTO.getCep();

        this.cidade = cidade;
    }

    public Empresa(EmpresaRequestDTO empresaRequestDTO) {
        this.razao = empresaRequestDTO.getRazao();
        this.fantasia = empresaRequestDTO.getFantasia();
        this.cnpj = empresaRequestDTO.getCnpj();
        this.ie = empresaRequestDTO.getIe();
        this.telefone = empresaRequestDTO.getTelefone();
        this.email = empresaRequestDTO.getEmail();
        this.endereco = empresaRequestDTO.getEndereco();
        this.numero = empresaRequestDTO.getNumero();
        this.bairro = empresaRequestDTO.getBairro();
        this.complemento = empresaRequestDTO.getComplemento();
        this.cep = empresaRequestDTO.getCep();
    }
}
