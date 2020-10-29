package io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.enums.StatusAluguel;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.AluguelRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="alugueis")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long  recibo;

    @Column(nullable = false)
    private LocalDate data;

    @ColumnDefault("0")
    @Column(nullable = false, scale = 2, precision = 20)
    private BigDecimal valor;

    @ColumnDefault("0")
    @Column(nullable = false, scale = 2, precision = 20)
    private BigDecimal iptu;

    @ColumnDefault("0")
    @Column(nullable = false, scale = 2, precision = 20)
    private BigDecimal seguro;

    @ColumnDefault("0")
    @Column(nullable = false, scale = 2, precision = 20)
    private BigDecimal multa;

    @ColumnDefault("0")
    @Column(nullable = false, scale = 2, precision = 20)
    private BigDecimal outros;

    @ColumnDefault("0")
    @Column(nullable = false, scale = 2, precision = 20)
    private BigDecimal desconto;

    @Column(nullable = false, scale = 2, precision = 20)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusAluguel status;

    @ManyToOne
    @JoinColumn(name="contrato_id")
    private Contrato contrato;

    public Aluguel(AluguelRequestDTO aluguelRequestDTO, Contrato contrato) {

        this.recibo = aluguelRequestDTO.getRecibo();
        this.data = aluguelRequestDTO.getData();
        this.valor = aluguelRequestDTO.getValor();
        this.iptu = aluguelRequestDTO.getIptu();
        this.seguro = aluguelRequestDTO.getSeguro();
        this.multa = aluguelRequestDTO.getMulta();
        this.outros = aluguelRequestDTO.getOutros();
        this.desconto = aluguelRequestDTO.getDesconto();
        this.status =  Enum.valueOf(StatusAluguel.class, aluguelRequestDTO.getStatus());

        this.total.add(this.valor);
        this.total.add(this.iptu);
        this.total.add(this.seguro);
        this.total.add(this.multa);
        this.total.add(this.outros);
        this.total.subtract(this.desconto);

        this.contrato = contrato;
    }
}
