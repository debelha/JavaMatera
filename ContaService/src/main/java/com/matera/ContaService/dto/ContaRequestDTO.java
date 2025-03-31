package com.matera.ContaService.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ContaRequestDTO {

    @NotNull
    private String nome;

    @NotNull
    private Integer agencia;

    @NotNull
    private Integer conta;

    @NotEmpty
    private String chavePix;
}
