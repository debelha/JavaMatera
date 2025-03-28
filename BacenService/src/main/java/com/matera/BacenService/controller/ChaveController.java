package com.matera.BacenService.controller;

import com.matera.BacenService.dto.ChaveRequestDTO;
import com.matera.BacenService.dto.ChaveResponseDTO;
import com.matera.BacenService.service.ChaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/api/bacen/chaves")
@RestController
@RequiredArgsConstructor
public class ChaveController {

    private final ChaveService chaveService;s 

    @PostMapping
    public ResponseEntity<ChaveResponseDTO> criarChave(@RequestBody ChaveRequestDTO chaveRequestDTO) {
        return ResponseEntity.status(CREATED).body(chaveService.criarChave(chaveRequestDTO));
    }

    @GetMapping("/{chave}")
    public ResponseEntity<ChaveResponseDTO> buscarChave(@PathVariable String chave) {
        return ResponseEntity.status(CREATED).body(chaveService.buscarChave(chave));
    }
}
