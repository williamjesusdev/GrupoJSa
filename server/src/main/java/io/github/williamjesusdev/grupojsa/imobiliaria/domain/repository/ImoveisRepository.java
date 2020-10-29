package io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImoveisRepository extends JpaRepository<Imovel, Integer> {
}
