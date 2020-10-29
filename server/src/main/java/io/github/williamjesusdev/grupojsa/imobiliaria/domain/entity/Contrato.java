package io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity;

import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.ContratoRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contratos")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Data é obrigatória")
    @Column(nullable = false)
    private LocalDate data;

    @Column(scale = 2, precision = 20)
    private BigDecimal valor;

    @Column
    private LocalDate validade;

    @NotBlank(message = "Cód locatário é obrigatório")
    @ManyToOne
    @JoinColumn(name="locatario_id")
    private Locatario locatario;

    @NotBlank(message = "Cód imóvel é obrigatório")
    @ManyToOne
    @JoinColumn(name="imovel_id")
    private Imovel imovel;

    @OneToMany(mappedBy = "contrato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Aluguel> alugueis;

    public Contrato(ContratoRequestDTO contratoRequestDTO, Imovel imovel, Locatario locatario) {
        this.data = contratoRequestDTO.getData();
        this.valor = contratoRequestDTO.getValor();
        this.validade = contratoRequestDTO.getValidade();

        this.locatario = locatario;
        this.imovel = imovel;
    }
}
