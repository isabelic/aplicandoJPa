package com.weg.atividadeJPA.dto.produto;

public record ProdutoRespostaDTO(
        Long id,
        String nome,
        String descricao,
        double preco,
        int quantidade
) {
}
