package com.matera.BacenService.repository;

import com.matera.BacenService.model.Chave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChaveRepository extends JpaRepository<Chave, UUID> {

    boolean existsByChave(final String chave);

    Optional<Chave> findByChave(final String chavePesquisada);
}
