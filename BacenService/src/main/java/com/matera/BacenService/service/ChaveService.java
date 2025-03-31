package com.matera.BacenService.service;

import com.matera.BacenService.dto.ChaveRequestDTO;
import com.matera.BacenService.dto.ChaveResponseDTO;
import com.matera.BacenService.exception.ChaveCadastradaException;
import com.matera.BacenService.exception.ChaveNaoLocalizadaException;
import com.matera.BacenService.model.Chave;
import com.matera.BacenService.repository.ChaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ChaveService {

    private final ChaveRepository chaveRepository;

    @Transactional
    public ChaveResponseDTO criarChave (final ChaveRequestDTO chaveRequestDTO) {

        if (chaveRepository.existsByChave(chaveRequestDTO.getChave())) {
            throw new ChaveCadastradaException(
                    String.format("Chave %s já cadastrada!", chaveRequestDTO.getChave())
            );
        }

        Chave chave = Chave.builder()
                .chave(chaveRequestDTO.getChave())
                .ativa(chaveRequestDTO.getAtiva())
                .build();

        chave = chaveRepository.save(chave);

        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }

    public ChaveResponseDTO buscarChave (final String chavePesquisada) {
        Chave chave = chaveRepository.findByChave(chavePesquisada).orElseThrow(
                () -> new ChaveNaoLocalizadaException(
                        String.format("Chave %s não existe!", chavePesquisada)
                ));

        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }
}
