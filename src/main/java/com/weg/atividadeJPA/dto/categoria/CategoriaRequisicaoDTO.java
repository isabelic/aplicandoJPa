package com.weg.atividadeJPA.dto.categoria;
import jakarta.validation.constraints.NotBlank;
public record CategoriaRequisicaoDTO(
            @NotBlank(message = "O nome da categoria é obrigatório")
            String nome,
            @NotBlank(message = "A descrição é obrigatória")
            String descricao
    ) {

}
