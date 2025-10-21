package com.weg.atividadeJPA.mapper;
import com.weg.atividadeJPA.dto.cliente.ClienteRequisicaoDTO;
import com.weg.atividadeJPA.dto.cliente.ClienteRespostaDTO;
import com.weg.atividadeJPA.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

        public Cliente paraEntidade(ClienteRequisicaoDTO requisicaoDTO){
            return new Cliente(requisicaoDTO.nome(),
                    requisicaoDTO.email(),
                    requisicaoDTO.telefone(),
                    requisicaoDTO.cpf());
        }

        public ClienteRespostaDTO paraRespostaDto(Cliente cliente){
            return new ClienteRespostaDTO(cliente.getId(),
                    cliente.getNome(),
                    cliente.getEmail(),
                    cliente.getTelefone(),
                    cliente.getCpf());
        }

        public Cliente paraUpdate(ClienteRequisicaoDTO requisicaoDTO, Cliente cliente){
            if(!requisicaoDTO.nome().equals(cliente.getNome())){
                cliente.setNome(requisicaoDTO.nome());
            }
            if(!requisicaoDTO.email().equals(cliente.getEmail())){
                cliente.setEmail(requisicaoDTO.email());
            }
            if(!requisicaoDTO.telefone().equals(cliente.getTelefone())){
                cliente.setTelefone(requisicaoDTO.telefone());
            }
            if(!requisicaoDTO.cpf().equals(cliente.getCpf())) {
                cliente.setCpf(requisicaoDTO.cpf());
            }
            return cliente;
        }
    }


