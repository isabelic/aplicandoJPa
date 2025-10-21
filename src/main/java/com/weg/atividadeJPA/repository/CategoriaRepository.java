package com.weg.atividadeJPA.repository;
import com.weg.atividadeJPA.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
        boolean existsCategoriaByNome(String nome);
    }


