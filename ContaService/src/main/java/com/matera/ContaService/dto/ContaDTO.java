package com.matera.ContaService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
public class ContaDTO {

    private UUID id;
    private String nome;
    private Integer agencia;
    private Integer conta;
    private String chavePix;
    private BigDecimal saldo;
}
