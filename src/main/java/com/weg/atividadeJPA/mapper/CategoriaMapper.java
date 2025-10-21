package com.weg.atividadeJPA.mapper;
import com.weg.atividadeJPA.dto.categoria.CategoriaRequisicaoDTO;
import com.weg.atividadeJPA.dto.categoria.CategoriaRespostaDTO;
import com.weg.atividadeJPA.model.Categoria;
import org.springframework.stereotype.Component;
@Component
public class CategoriaMapper {


        public Categoria paraEntidade(CategoriaRequisicaoDTO requisicaoDTO){
            return new Categoria( requisicaoDTO.nome(), requisicaoDTO.descricao());
        }

        public CategoriaRespostaDTO paraRespostaDto(Categoria categoria){
            return new CategoriaRespostaDTO(categoria.getId(),
                    categoria.getNome(),
                    categoria.getDescricao());
        }

        public Categoria paraUpdate(CategoriaRequisicaoDTO requisicaoDTO, Categoria categoria){
            if(!requisicaoDTO.nome().equals(categoria.getNome())){
                categoria.setNome(requisicaoDTO.nome());
            }
            if(!requisicaoDTO.descricao().equals(categoria.getDescricao())){
                categoria.setDescricao(requisicaoDTO.descricao());
            }
            return categoria;
        }
    }


