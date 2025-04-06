package com.matera.ContaService.service;

import com.matera.ContaService.dto.PixDTO;
import com.matera.ContaService.dto.PixRequestDTO;
import com.matera.ContaService.dto.PixResponseDTO;
import com.matera.ContaService.exception.ContaInexistenteException;
import com.matera.ContaService.exception.SaldoInsuficienteException;
import com.matera.ContaService.model.Conta;
import com.matera.ContaService.model.Pix;
import com.matera.ContaService.repository.ContaRepository;
import com.matera.ContaService.repository.PixRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PixService {

    private final PixRepository pixRepository;
    private final ContaRepository contaRepository;

    @Transactional
    public PixResponseDTO realizarPix(PixRequestDTO pixRequestDTO) {

        if (pixRequestDTO.getValor().compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("Valor negativo");
        }

        Optional<Pix> existingPix = pixRepository.findByIdempotencia(pixRequestDTO.getIdempotencia());

        if (existingPix.isPresent()) {
            return new PixResponseDTO(
                    existingPix.get().getCreatedAt(),
                    "Pix já processado(idempotente)",
                    existingPix.map(this:: entityToDto).get()
            );
        }

        Optional<Conta> contaPagadorOptional = contaRepository.findByChavePix(pixRequestDTO.getChavePixPagador());

        if (contaPagadorOptional.isEmpty()) {
            throw new ContaInexistenteException(String.format("Conta com a chave %s não existe", pixRequestDTO.getChavePixPagador()));
        }

        Optional<Conta> contaRecebedorOptional = contaRepository.findByChavePix(pixRequestDTO.getChavePixRecebedor());

        if (contaRecebedorOptional.isEmpty()) {
            throw new ContaInexistenteException(String.format("Conta com a chave %s não existe", pixRequestDTO.getChavePixRecebedor()));
        }

        Conta contaPagador = contaPagadorOptional.get();
        Conta contaRecebedor = contaRecebedorOptional.get();

        if(pixRequestDTO.getValor().compareTo(contaPagador.getSaldo()) > 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        contaPagador.sacar(pixRequestDTO.getValor());
        contaRecebedor.depositar(pixRequestDTO.getValor());

        contaRepository.save(contaPagador);
        contaRepository.save(contaRecebedor);

        Pix pix = Pix.builder()
                .chavePixPagador(pixRequestDTO.getChavePixPagador())
                .chavePixRecebedor(pixRequestDTO.getChavePixRecebedor())
                .conta(contaPagador)
                .valor(pixRequestDTO.getValor())
                .idempotencia(pixRequestDTO.getIdempotencia())
                .createdAt(LocalDateTime.now())
                .build();

        pixRepository.save(pix);

        return PixResponseDTO.builder()
                .pix(entityToDto(pix))
                .createdAt(pix.getCreatedAt())
                .message("Pix realizado com sucesso")
                .build();
    }

    private PixDTO entityToDto(Pix pix) {
        return PixDTO.builder()
                .id(pix.getId())
                .chavePixPagador(pix.getChavePixPagador())
                .chavePixRecebedor(pix.getChavePixRecebedor())
                .valor(pix.getValor())
                .createdAt(pix.getCreatedAt())
                .idempotencia(pix.getIdempotencia())
                .build();
    }
}
