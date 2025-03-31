package com.matera.ContaService.repository;

import com.matera.ContaService.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID>{

    Optional<Conta> findChavePix(String chavePixPagador);

    Optional<Conta> findByNomeAndContaAndChavePix(String nome, Integer conta, String chavePix);


}
