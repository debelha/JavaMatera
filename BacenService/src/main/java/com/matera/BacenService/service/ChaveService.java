package com.matera.BacenService.service;

import com.matera.BacenService.dto.ChaveRequestDTO;
import com.matera.BacenService.dto.ChaveResponseDTO;
import com.matera.BacenService.model.Chave;
import com.matera.BacenService.repository.ChaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChaveService {

    private final ChaveRepository chaveRepository;

    public ChaveResponseDTO criarChave (final ChaveRequestDTO chaveRequestDTO) {
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
}
