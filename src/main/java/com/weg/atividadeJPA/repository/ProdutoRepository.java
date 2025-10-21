package com.weg.atividadeJPA.repository;

import com.weg.atividadeJPA.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsProdutoByNome(String nome);

}
