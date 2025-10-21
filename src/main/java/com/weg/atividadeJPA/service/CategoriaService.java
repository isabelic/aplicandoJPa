package com.weg.atividadeJPA.service;
import com.weg.atividadeJPA.dto.CategoriaRequisicaoDTO;
import com.weg.atividadeJPA.dto.CategoriaRespostaDTO;
import com.weg.atividadeJPA.exception.CategoriaNaoExisteException;
import com.weg.atividadeJPA.exception.EntidadeJaExisteException;
import com.weg.atividadeJPA.mapper.CategoriaMapper;
import com.weg.atividadeJPA.model.Categoria;
import com.weg.atividadeJPA.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
public class CategoriaService {


        private final CategoriaRepository repository;
        private final CategoriaMapper mapper;

    public CategoriaRespostaDTO criar(CategoriaRequisicaoDTO dto){
        if(repository.existsCategoriaByNome(dto.nome())){
            throw new EntidadeJaExisteException("Categoria com esse nome já existe!");
        }
        return mapper.paraRespostaDto(repository.save(mapper.paraEntidade(dto)));
    }


    public List<CategoriaRespostaDTO> buscarTodos(){
            return repository.findAll().stream().map(mapper::paraRespostaDto).toList();
        }

        public CategoriaRespostaDTO buscarPorId(Long id){
            return mapper.paraRespostaDto(
                    repository.findById(id).orElseThrow(CategoriaNaoExisteException::new)
            );
        }

        public CategoriaRespostaDTO atualizar(Long id, CategoriaRequisicaoDTO dto){
            Categoria categoria = repository.findById(id).orElseThrow(CategoriaNaoExisteException::new);
            repository.save(mapper.paraUpdate(dto, categoria));
            return mapper.paraRespostaDto(categoria);
        }

        public void excluir(Long id){
            if(!repository.existsById(id)) throw new CategoriaNaoExisteException();
            repository.deleteById(id);
        }
    }


