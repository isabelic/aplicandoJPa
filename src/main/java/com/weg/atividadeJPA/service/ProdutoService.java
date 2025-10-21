package com.weg.atividadeJPA.service;

import com.weg.atividadeJPA.dto.ProdutoRequisicaoDTO;
import com.weg.atividadeJPA.dto.ProdutoRespostaDTO;
import com.weg.atividadeJPA.exception.ProdutoNaoExisteException;
import com.weg.atividadeJPA.mapper.ProdutoMapper;
import com.weg.atividadeJPA.model.Produto;
import com.weg.atividadeJPA.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.aspectj.util.PartialOrder;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    private  final ProdutoMapper mapper;

    public ProdutoRespostaDTO criar(ProdutoRequisicaoDTO requisicaoDTO){
        return mapper.paraRespostaDto(repository.save(mapper.paraEntidade(requisicaoDTO)));
    }


    public List<ProdutoRespostaDTO> buscarTodos(){
        return repository.findAll().stream().map(mapper::paraRespostaDto).toList();
    }

    public ProdutoRespostaDTO buscarPorId(Long id) {
        return mapper.paraRespostaDto(repository.findById(id)
                .orElseThrow(() -> {
                    throw new ProdutoNaoExisteException();
                }));
    }

    public ProdutoRespostaDTO atualizar(Long id, ProdutoRequisicaoDTO requisicaoDTO){
        Produto produto = repository.findById(id).orElseThrow(() -> {
            throw new ProdutoNaoExisteException();
        });

        Produto newProduto = mapper.paraUpdate(requisicaoDTO,produto);
        repository.save(newProduto);
        return  mapper.paraRespostaDto(newProduto);
    }

    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new ProdutoNaoExisteException();
        }
        repository.deleteById(id);
    }

}
