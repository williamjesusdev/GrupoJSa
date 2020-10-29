package io.github.williamjesusdev.grupojsa.empresa.domain.repository;

import io.github.williamjesusdev.grupojsa.empresa.domain.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresa, Integer> {
}
