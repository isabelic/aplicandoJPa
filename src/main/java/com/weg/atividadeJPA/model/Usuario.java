package com.weg.atividadeJPA.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String nome;


    private String descricao;

    private double preco;

    @Positive(message = "Quantidade dev ser")

    private int quantidade;



}
