package com.weg.atividadeJPA.service;

import com.weg.atividadeJPA.dto.fornecedor.FornecedorRequisicaoDTO;
import com.weg.atividadeJPA.dto.fornecedor.FornecedorRespostaDTO;
import com.weg.atividadeJPA.exception.EntidadeJaExisteException;
import com.weg.atividadeJPA.exception.FornecedorNaoExisteException;
import com.weg.atividadeJPA.mapper.FornecedorMapper;
import com.weg.atividadeJPA.model.Fornecedor;
import com.weg.atividadeJPA.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FornecedorService {


        private final FornecedorRepository repository;
        private final FornecedorMapper mapper;

        public FornecedorRespostaDTO criar(FornecedorRequisicaoDTO requisicaoDTO){
            if(repository.existsFornecedorByCnpj(requisicaoDTO.cnpj())){
                throw new EntidadeJaExisteException("Fornecedor com este CNPJ já existe!");
            }
            return mapper.paraRespostaDto(repository.save(mapper.paraEntidade(requisicaoDTO)));
        }

        public List<FornecedorRespostaDTO> buscarTodos(){
            return repository.findAll().stream().map(mapper::paraRespostaDto).toList();
        }

        public FornecedorRespostaDTO buscarPorId(Long id){
            return mapper.paraRespostaDto(repository.findById(id).orElseThrow(FornecedorNaoExisteException::new));
        }

        public FornecedorRespostaDTO atualizar(Long id, FornecedorRequisicaoDTO requisicaoDTO){
            Fornecedor fornecedor = repository.findById(id).orElseThrow(FornecedorNaoExisteException::new);
            repository.save(mapper.paraUpdate(requisicaoDTO, fornecedor));
            return mapper.paraRespostaDto(fornecedor);
        }

        public void excluir(Long id){
            if(!repository.existsById(id))
                throw new FornecedorNaoExisteException();
            repository.deleteById(id);
        }
    }


