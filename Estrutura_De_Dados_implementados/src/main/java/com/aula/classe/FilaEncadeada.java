package com.aula.classe;

import com.aula.iClasse.Fila;

import java.util.NoSuchElementException;

public class FilaEncadeada<T> implements Fila<T> {

    private static class No<T>{
        T dado;
        No<T> prox;
        No(T dado){
            this.dado = dado;
        }
    }

    private No<T> inicio;
    private No<T> fim;
    private Integer tamanho;

    public FilaEncadeada(){
        inicio = fim = null;
        tamanho = 0;
    }


    @Override
    public void enfileirar(T item) {
        No<T> novo = new No<>(item);
        if(vazia()){
            inicio = fim = novo;
        } else{
            fim.prox = novo;
            fim = novo;
        }
        tamanho++;
    }

    @Override
    public T desenfileirar() {
        if(vazia()) throw new NoSuchElementException("Fila Vazia!");
        T valor = inicio.dado;
        inicio = inicio.prox;
        if(inicio == null) fim = null;
        tamanho --;
        return valor;
    }

    @Override
    public T primeiro() {
        if(vazia())throw new NoSuchElementException("Fila Vazia!");
        return inicio.dado;
    }

    @Override
    public Boolean vazia() {
        return tamanho == 0;
    }

    @Override
    public Integer tamanho() {
        return tamanho;
    }
}
