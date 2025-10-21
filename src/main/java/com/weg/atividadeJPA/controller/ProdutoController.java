package com.weg.atividadeJPA.controller;

import com.weg.atividadeJPA.dto.ProdutoRequisicaoDTO;
import com.weg.atividadeJPA.dto.ProdutoRespostaDTO;
import com.weg.atividadeJPA.model.Produto;
import com.weg.atividadeJPA.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {


    private final ProdutoService service;


    @PostMapping
    public ResponseEntity<ProdutoRespostaDTO> criar(
            @RequestBody ProdutoRequisicaoDTO requisicaoDTO
            ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(requisicaoDTO));
    }


    @GetMapping
    public ResponseEntity<List<ProdutoRespostaDTO>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDTO> buscarPorId(
            @PathVariable Long id
    ){

        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDTO> atualizar (
            @PathVariable Long id,
            @RequestBody ProdutoRequisicaoDTO requisicaoDTO
    ){
        return  ResponseEntity.status(HttpStatus.OK)
                .body(service.atualizar(id, requisicaoDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id

    ){
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
