package com.matera.ContaService.controller;

import com.matera.ContaService.dto.ContaRequestDTO;
import com.matera.ContaService.dto.ContaResponseDTO;
import com.matera.ContaService.service.ContaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/contas")
@RequiredArgsConstructor
public class ContaController {
    private final ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaResponseDTO> conta(@RequestBody @Valid ContaRequestDTO contaRequestDTO) throws Exception {
        ContaResponseDTO contaResponseDTO = contaService.criarConta(contaRequestDTO);
        return new ResponseEntity<>(contaResponseDTO, CREATED);
    }

}
