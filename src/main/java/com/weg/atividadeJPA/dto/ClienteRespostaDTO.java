package com.weg.atividadeJPA.dto;

public record ClienteRespostaDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf
) {
}
