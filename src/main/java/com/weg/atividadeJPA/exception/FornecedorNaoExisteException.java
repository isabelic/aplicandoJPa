package com.weg.atividadeJPA.exception;

public class FornecedorNaoExisteException extends RuntimeException {
    public FornecedorNaoExisteException() {
        super("Fornecedor não encontrado!");


    }
}
