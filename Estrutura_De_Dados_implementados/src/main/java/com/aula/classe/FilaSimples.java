package com.aula.classe;

import com.aula.iClasse.Fila;

public class FilaSimples<T> implements Fila<T> {

    private T[] dados;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaSimples(){
        this(10);
    }
    @SuppressWarnings("unchecked")
    public FilaSimples(int capacidade){
        dados = (T[]) new Object[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    @Override
    public void enfileirar(T item) {
        if (tamanho == dados.length) {
            throw new RuntimeException("Fila cheia");
        }
        dados[fim] = item;
        fim = (fim + 1) % dados.length;
        tamanho++;
    }

    @Override
    public T desenfileirar() {
        if (vazia()) {
            return null;
        }
        T item = dados[inicio];
        dados[inicio] = null;
        inicio = (inicio + 1) % dados.length;
        tamanho--;
        return item;
    }

    @Override
    public T primeiro() {
        if (vazia()) {
            return null;
        }
        return dados[inicio];
    }

    @Override
    public Boolean vazia() {
        return tamanho == 0;
    }

    @Override
    public Integer tamanho() {
        return tamanho;
    }

    public void printFila(){
        if (vazia()){
            System.out.println("Impressão da Fila: ");
            System.out.println("Fila vazia");
        } else {
            System.out.println("Impressão da Fila: ");
            int idx = inicio;
            System.out.print(dados[idx]);
            for (int i = 1; i < tamanho; i++){
                idx = (inicio + i) % dados.length;
                System.out.print(" - " + dados[idx]);
            }
            System.out.println();
        }
    }
}
