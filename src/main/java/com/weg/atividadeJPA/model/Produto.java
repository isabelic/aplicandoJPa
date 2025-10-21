package com.weg.atividadeJPA.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import jakarta.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "usuarios")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @Column(length = 100)
    private String descricao;


    @Positive(message = "O preço deve ser positivo")
    @Column(nullable = false)
    private double preco;


    @Column(name = "quantidade_produto")
    @PositiveOrZero(message = "A quantidade não pode ser negativa!")
    private int quantidade;


    public Produto(String nome, String descricao, double preco, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
