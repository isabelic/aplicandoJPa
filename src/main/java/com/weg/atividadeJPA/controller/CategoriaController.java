package com.weg.atividadeJPA.controller;
import com.weg.atividadeJPA.dto.CategoriaRequisicaoDTO;
import com.weg.atividadeJPA.dto.CategoriaRespostaDTO;
import com.weg.atividadeJPA.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaController {


        private final CategoriaService service;

        @PostMapping
        public ResponseEntity<CategoriaRespostaDTO> criar(@RequestBody CategoriaRequisicaoDTO dto){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
        }

        @GetMapping
        public ResponseEntity<List<CategoriaRespostaDTO>> buscarTodos(){
            return ResponseEntity.ok(service.buscarTodos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<CategoriaRespostaDTO> buscarPorId(@PathVariable Long id){
            return ResponseEntity.ok(service.buscarPorId(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<CategoriaRespostaDTO> atualizar(@PathVariable Long id,
                                                              @RequestBody CategoriaRequisicaoDTO dto){
            return ResponseEntity.ok(service.atualizar(id, dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> excluir(@PathVariable Long id){
            service.excluir(id);
            return ResponseEntity.noContent().build();
        }
    }


