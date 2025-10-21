package com.weg.atividadeJPA.exception;

public class CategoriaNaoExisteException extends RuntimeException{

        public CategoriaNaoExisteException(){
            super("Categoria não encontrada!");
        }


}
