package com.weg.atividadeJPA.dto.fornecedor;

public record FornecedorRespostaDTO (
        Long id,
        String nome,
        String cnpj,
        String email,
        String telefone
){
}
