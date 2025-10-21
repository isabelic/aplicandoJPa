package com.weg.atividadeJPA.dto.fornecedor;

import jakarta.validation.constraints.NotBlank;

public record FornecedorRequisicaoDTO (
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "CNPJ é obrigatório")
        String cnpj,
        @NotBlank(message = "Email é obrigatório")
        String email,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone
){
}
