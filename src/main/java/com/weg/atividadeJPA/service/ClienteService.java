package com.weg.atividadeJPA.service;
import com.weg.atividadeJPA.dto.cliente.ClienteRequisicaoDTO;
import com.weg.atividadeJPA.dto.cliente.ClienteRespostaDTO;
import com.weg.atividadeJPA.exception.ClienteNaoExisteException;
import com.weg.atividadeJPA.exception.EntidadeJaExisteException;
import com.weg.atividadeJPA.mapper.ClienteMapper;
import com.weg.atividadeJPA.model.Cliente;
import com.weg.atividadeJPA.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

        private final ClienteRepository repository;
        private final ClienteMapper mapper;

        public ClienteRespostaDTO criar(ClienteRequisicaoDTO dto){
            if(repository.existsClienteByCpf(dto.cpf())){
                throw new EntidadeJaExisteException("Cliente com este CPF já existe no sistema!");
            }
            return mapper.paraRespostaDto(repository.save(mapper.paraEntidade(dto)));
        }

        public List<ClienteRespostaDTO> buscarTodos(){
            return repository.findAll().stream().map(mapper::paraRespostaDto).toList();
        }

        public ClienteRespostaDTO buscarPorId(Long id){
            return mapper.paraRespostaDto(repository.findById(id).orElseThrow(ClienteNaoExisteException::new));
        }

        public ClienteRespostaDTO atualizar(Long id, ClienteRequisicaoDTO dto){
            Cliente cliente = repository.findById(id).orElseThrow(ClienteNaoExisteException::new);
            repository.save(mapper.paraUpdate(dto, cliente));
            return mapper.paraRespostaDto(cliente);
        }

        public void excluir(Long id){
            if(!repository.existsById(id)) throw new ClienteNaoExisteException();
            repository.deleteById(id);
        }
    }


