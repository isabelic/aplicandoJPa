package com.weg.atividadeJPA.dto.cliente;
import jakarta.validation.constraints.NotBlank;
public record ClienteRequisicaoDTO(

            @NotBlank(message = "Nome é obrigatório")
            String nome,
            @NotBlank(message = "Email é obrigatório")
            String email,
            @NotBlank(message = "Telefone é obrigatório")
            String telefone,
            @NotBlank(message = "CPF é obrigatório")
            String cpf
    ) {
}


