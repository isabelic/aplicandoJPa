package com.weg.atividadeJPA.repository;
import com.weg.atividadeJPA.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository  extends JpaRepository<Fornecedor, Long>{
        boolean existsFornecedorByCnpj(String cnpj);


}
