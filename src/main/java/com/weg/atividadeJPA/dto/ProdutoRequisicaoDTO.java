package com.weg.atividadeJPA.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoRequisicaoDTO(
        @NotBlank(message = "O nome do produto é obrigatório!")
        String nome,

        @NotBlank(message = "A descrição é obrigatória!")
        String descricao,

        @NotBlank(message = "O preço é obrigatório!")
        @Positive
        double preco,


        @NotNull(message ="A quatidade é obrigatória!")
        @PositiveOrZero
        int quantidade



) {



}
