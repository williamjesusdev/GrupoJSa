package io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Aluguel;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.DimobTotalByMonthResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DimobRepository extends JpaRepository<Aluguel, Long> {

    @Query("select new io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.DimobTotalByMonthResponseDTO(" +
            "e.id, " +
            "e.fantasia, " +
            "MONTH(a.data), " +
            "SUM(a.total)) " +
            "from Aluguel a " +
            "join a.contrato c " +
            "join c.imovel i " +
            "join i.proprietario e " +
            "where YEAR(a.data) =:ano " +
            "group by e.id, e.fantasia, MONTH(a.data) " +
            "order by e.id, MONTH(a.data)")
    List<DimobTotalByMonthResponseDTO> getDimobMensalByAno(@Param("ano") Integer ano);

    @Query("select new io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.DimobTotalByMonthResponseDTO(" +
            "e.id, " +
            "e.fantasia, " +
            "MONTH(a.data), " +
            "SUM(a.total)) " +
            "from Aluguel a " +
            "join a.contrato c " +
            "join c.imovel i " +
            "join i.proprietario e " +
            "where YEAR(a.data) = (select MAX(YEAR(a.data)) from Aluguel a) " +
            "and MONTH(a.data) = (select MAX(MONTH(a.data)) from Aluguel a " +
            "                     where YEAR(a.data) = (select MAX(YEAR(a.data)) from Aluguel a)) " +
            "and a.status = 'RECEBIDO'" +
            "group by e.id, e.fantasia, MONTH(a.data) " +
            "order by e.id, MONTH(a.data)")
    List<DimobTotalByMonthResponseDTO> getDimobUltimoMes();
}
