package com.matera.ContaService.service;

import com.matera.ContaService.dto.ContaRequestDTO;
import com.matera.ContaService.dto.ContaResponseDTO;
import com.matera.ContaService.exception.ContaExistenteException;
import com.matera.ContaService.model.Conta;
import com.matera.ContaService.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContaService {

    public final ContaRepository contaRepository;

    public ContaResponseDTO criarConta(ContaRequestDTO contaRequestDTO) {
        Optional<Conta> contaOptional = contaRepository.findByNomeAndContaAndChavePix(
                contaRequestDTO.getNome(),
                contaRequestDTO.getConta(),
                contaRequestDTO.getChavePix()
        );

        if (contaOptional.isPresent()) {
            throw new ContaExistenteException("Conta já existe.");
        }

        Conta conta = Conta.builder()
                .nome(contaRequestDTO.getNome())
                .agencia(contaRequestDTO.getAgencia())
                .conta(contaRequestDTO.getConta())
                .chavePix(contaRequestDTO.getChavePix())
                .saldo(new BigDecimal(5000))
                .build();

        Conta contaSalva = contaRepository.save(conta);

        ContaResponseDTO contaResponseDTO = ContaResponseDTO.builder()
                .id(contaSalva.getId())
                .nome(contaRequestDTO.getNome())
                .build();

        log.info("ContaResponseDTO: {}", contaResponseDTO);

        return contaResponseDTO;

    }
}
