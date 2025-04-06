package com.matera.ContaService.feign;

import com.matera.ContaService.exception.ErroIntegracaoBacenException;
import com.matera.ContaService.feign.dto.ChaveRequestDTO;
import com.matera.ContaService.feign.dto.ChaveResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BacenService {

    private final BacenClient bacenClient;

    public ChaveResponseDTO criarChave(final String chave) {
        try {
            ChaveRequestDTO chaveRequestDTO = ChaveRequestDTO.builder()
                    .chave(chave)
                    .ativa(Boolean.TRUE)
                    .build();
            return bacenClient.criarChave(chaveRequestDTO);

        } catch (Exception ex) {
            log.error("Erro ao chamar a API de cadastrar chave do Bacen", ex);
            throw new ErroIntegracaoBacenException("Erro ao cadastrar a chave no Bacen");
        }
    }

    public ChaveResponseDTO buscarChave(final String chave) {
        try {
            return bacenClient.buscarChave(chave);
        } catch (Exception ex) {
            log.error("Erro ao chamar a API de buscar chave do Bacen", ex);
            throw new ErroIntegracaoBacenException("Erro ao buscar a chave no Bacen");
        }
    }

}
