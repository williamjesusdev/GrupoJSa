package io.github.williamjesusdev.grupojsa.core.domain.repository;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadesRepository extends JpaRepository<Cidade, Integer> {
}
