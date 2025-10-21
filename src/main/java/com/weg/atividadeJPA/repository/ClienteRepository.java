package com.weg.atividadeJPA.repository;
import com.weg.atividadeJPA.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public  interface ClienteRepository extends JpaRepository<Cliente, Long>{
        boolean existsClienteByCpf(String cpf);


}
