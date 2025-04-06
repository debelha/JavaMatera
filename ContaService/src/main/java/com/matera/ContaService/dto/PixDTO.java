package com.matera.ContaService.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class PixDTO {
    private UUID id;
    private LocalDateTime createdAt;
    private String chavePixPagador;
    private String chavePixRecebedor;
    private BigDecimal valor;
    private String idempotencia;
}
