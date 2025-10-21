package com.weg.atividadeJPA.dto;

public record ProdutoRespostaDTO(
        Long id,
        String nome,
        String descricao,
        double preco,
        int quantidade
) {
}
