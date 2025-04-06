package com.matera.ContaService.feign;

import com.matera.ContaService.feign.dto.ChaveRequestDTO;
import com.matera.ContaService.feign.dto.ChaveResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        contextId = "BacenClient",
        name = "Bancen",
        url = "http://localhost:8080/api/bacen"
)

public interface BacenClient {

    @PostMapping("/chaves")
    ChaveResponseDTO criarChave(ChaveRequestDTO chaveRequestDTO);

    @GetMapping(value = "/chaves/{chave}")
    ChaveResponseDTO buscarChave(@PathVariable final String chave);
}
