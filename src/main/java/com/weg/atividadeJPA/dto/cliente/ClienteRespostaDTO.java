package com.weg.atividadeJPA.dto.cliente;

public record ClienteRespostaDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf
) {
}
