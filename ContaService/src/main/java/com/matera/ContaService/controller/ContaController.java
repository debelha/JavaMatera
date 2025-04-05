package com.matera.ContaService.controller;

import com.matera.ContaService.dto.ContaDTO;
import com.matera.ContaService.dto.ContaRequestDTO;
import com.matera.ContaService.dto.ContaResponseDTO;
import com.matera.ContaService.service.ContaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<ContaDTO>> contas(){
        return ResponseEntity.status(HttpStatus.OK).body(contaService.buscarTodasContas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> conta(@PathVariable UUID id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.buscarContaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaResponseDTO> atualizarConta(@RequestBody @Valid ContaRequestDTO contaRequestDTO,@PathVariable UUID id) throws Exception {
        ContaResponseDTO contaResponseDTO = contaService.atualizarConta(contaRequestDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(contaResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConta(@PathVariable UUID id) {
        contaService.deletarConta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
