package com.weg.atividadeJPA.mapper;

import com.weg.atividadeJPA.dto.fornecedor.FornecedorRequisicaoDTO;
import com.weg.atividadeJPA.dto.fornecedor.FornecedorRespostaDTO;
import com.weg.atividadeJPA.model.Fornecedor;
import org.springframework.stereotype.Component;

@Component
public class FornecedorMapper {


        public Fornecedor paraEntidade(FornecedorRequisicaoDTO requisicaoDTO){
            return new Fornecedor( requisicaoDTO.nome(),
                    requisicaoDTO.cnpj(),
                    requisicaoDTO.email(),
                    requisicaoDTO.telefone());
        }

        public FornecedorRespostaDTO paraRespostaDto(Fornecedor fornecedor){
            return new FornecedorRespostaDTO(fornecedor.getId(),
                    fornecedor.getNome(),
                    fornecedor.getCnpj(),
                    fornecedor.getEmail(),
                    fornecedor.getTelefone());
        }

        public Fornecedor paraUpdate(FornecedorRequisicaoDTO requisicaoDTO, Fornecedor fornecedor){
            if(!requisicaoDTO.nome().equals(fornecedor.getNome())){
                fornecedor.setNome(requisicaoDTO.nome());
            }
            if(!requisicaoDTO.cnpj().equals(fornecedor.getCnpj())){
                fornecedor.setCnpj(requisicaoDTO.cnpj());
            }
            if(!requisicaoDTO.email().equals(fornecedor.getEmail())) {
                fornecedor.setEmail(requisicaoDTO.email());
            }
            if(!requisicaoDTO.telefone().equals(fornecedor.getTelefone())) {
                fornecedor.setTelefone(requisicaoDTO.telefone());
            }
            return fornecedor;
        }
    }


