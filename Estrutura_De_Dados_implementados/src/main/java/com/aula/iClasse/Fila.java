package com.aula.iClasse;

public interface Fila<T> {
    void enfileirar(T item);
    T desenfileirar();
    T primeiro();
    Boolean vazia();
    Integer tamanho();
}
