package io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.empresa.domain.entity.Empresa;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.ImovelRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="imoveis")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String matricula;

    @Column(nullable = false, scale = 2, precision = 20)
    private BigDecimal valor;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    private Boolean alugado;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    private Boolean obra;

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

    @ManyToOne
    @JoinColumn(name="proprietario_id")
    private Empresa proprietario;

    @OneToMany(mappedBy = "imovel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contrato> contratos;

    public Imovel(ImovelRequestDTO imovelRequestDTO, Cidade cidade, Empresa proprietario) {
        this.matricula = imovelRequestDTO.getMatricula();
        this.valor = imovelRequestDTO.getValor();
        this.alugado = imovelRequestDTO.getAlugado();
        this.obra = imovelRequestDTO.getObra();
        this.endereco = imovelRequestDTO.getEndereco();
        this.numero = imovelRequestDTO.getNumero();
        this.bairro = imovelRequestDTO.getBairro();
        this.complemento = imovelRequestDTO.getComplemento();
        this.cep = imovelRequestDTO.getCep();

        this.cidade = cidade;
        this.proprietario = proprietario;
    }
}
