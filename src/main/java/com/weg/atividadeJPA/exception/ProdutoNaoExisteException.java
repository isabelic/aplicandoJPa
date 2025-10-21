package com.weg.atividadeJPA.exception;

public class ProdutoNaoExisteException extends  RuntimeException{

    public ProdutoNaoExisteException(){
        super("Produto não encontrado no sistema!");
    }

}
