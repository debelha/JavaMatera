package com.matera.ContaService.service;

import com.matera.ContaService.dto.ContaDTO;
import com.matera.ContaService.dto.ContaRequestDTO;
import com.matera.ContaService.dto.ContaResponseDTO;
import com.matera.ContaService.exception.ContaExistenteException;
import com.matera.ContaService.exception.ContaInexistenteException;
import com.matera.ContaService.model.Conta;
import com.matera.ContaService.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public List<ContaDTO> buscarTodasContas() {

        List<ContaDTO> contas = contaRepository.findAll().stream().map(
                conta -> ContaDTO.builder()
                        .id(conta.getId())
                        .nome(conta.getNome())
                        .agencia(conta.getAgencia())
                        .conta(conta.getConta())
                        .chavePix(conta.getChavePix())
                        .saldo(conta.getSaldo())
                        .build())
                .toList();

        return contas;
    }

    public ContaDTO buscarContaById(UUID id) {

        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ContaInexistenteException("Conta não existe"));

        ContaDTO contaDTO = ContaDTO.builder()
                .id(conta.getId())
                .nome(conta.getNome())
                .agencia(conta.getAgencia())
                .conta(conta.getConta())
                .chavePix(conta.getChavePix())
                .saldo(conta.getSaldo())
                .build();

        return contaDTO;
    }

    public ContaResponseDTO atualizarConta(ContaRequestDTO contaRequestDTO, UUID id) {

        Conta contaExistente = contaRepository.findById(id)
                .orElseThrow(() -> new ContaInexistenteException("Conta não existe."));

        contaExistente.setNome(contaRequestDTO.getNome());
        contaExistente.setConta(contaRequestDTO.getConta());
        contaExistente.setAgencia(contaRequestDTO.getAgencia());
        contaExistente.setChavePix(contaRequestDTO.getChavePix());

        contaExistente = contaRepository.save(contaExistente);

        return ContaResponseDTO.builder()
                .id(contaExistente.getId())
                .nome(contaExistente.getNome())
                .build();
    }

    public void deletarConta(UUID id) {
        contaRepository.findById(id).orElseThrow(() -> new ContaInexistenteException("Conta não existe."));

        contaRepository.deleteById(id);
    }
}
