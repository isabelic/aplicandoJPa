package com.weg.atividadeJPA.controller;
import com.weg.atividadeJPA.dto.fornecedor.FornecedorRequisicaoDTO;
import com.weg.atividadeJPA.dto.fornecedor.FornecedorRespostaDTO;
import com.weg.atividadeJPA.service.FornecedorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
@AllArgsConstructor
public class FornecedorController {

        private final FornecedorService service;

        @PostMapping
        public ResponseEntity<FornecedorRespostaDTO> criar(
                @RequestBody FornecedorRequisicaoDTO requisicaoDTO){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.criar(requisicaoDTO));
        }

        @GetMapping
        public ResponseEntity<List<FornecedorRespostaDTO>> buscarTodos(){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarTodos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<FornecedorRespostaDTO> buscarPorId(
                @PathVariable Long id
        ){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarPorId(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<FornecedorRespostaDTO> atualizar(
                @PathVariable Long id,
                @RequestBody FornecedorRequisicaoDTO dto){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.atualizar(id, dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> excluir(
                @PathVariable Long id){
            service.excluir(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }


