package com.weg.atividadeJPA.controller;

import com.weg.atividadeJPA.dto.ClienteRequisicaoDTO;
import com.weg.atividadeJPA.dto.ClienteRespostaDTO;
import com.weg.atividadeJPA.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

        private final ClienteService service;

        @PostMapping
        public ResponseEntity<ClienteRespostaDTO> criar(@RequestBody ClienteRequisicaoDTO dto){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
        }

        @GetMapping
        public ResponseEntity<List<ClienteRespostaDTO>> buscarTodos(){
            return ResponseEntity.ok(service.buscarTodos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<ClienteRespostaDTO> buscarPorId(@PathVariable Long id){
            return ResponseEntity.ok(service.buscarPorId(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<ClienteRespostaDTO> atualizar(@PathVariable Long id,
                                                            @RequestBody ClienteRequisicaoDTO dto){
            return ResponseEntity.ok(service.atualizar(id, dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> excluir(@PathVariable Long id){
            service.excluir(id);
            return ResponseEntity.noContent().build();
        }
    }


