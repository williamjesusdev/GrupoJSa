package io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Aluguel;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.AluguelResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlugueisRepository extends JpaRepository<Aluguel, Long> {

    @Query("select a from Aluguel a " +
            "where MONTH(a.data) =:mes " +
            "and YEAR(a.data) = (select MAX(YEAR(a.data)) from Aluguel a)")
    List<Aluguel> getAllAlugueisByMes(@Param("mes") Integer mes);

    List<Aluguel> findByRecibo(@Param("recibo") Long recibo);
}
