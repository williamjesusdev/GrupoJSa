package io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository;

import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatariosRepository extends JpaRepository<Locatario, Integer> {
}
