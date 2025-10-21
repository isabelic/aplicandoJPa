package com.weg.atividadeJPA.repository;

import com.weg.atividadeJPA.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsProdutoByNome(String nome);

}
