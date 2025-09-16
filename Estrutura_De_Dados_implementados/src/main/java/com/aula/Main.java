package com.aula;

import com.aula.classe.FilaEncadeada;
import com.aula.classe.FilaSimples;


public class Main {
    public static void main(String[] args) {

        FilaEncadeada<String> fila = new FilaEncadeada<>();

        fila.enfileirar("10");
        fila.enfileirar("A");
        fila.enfileirar("B");
//        System.out.println("Primeiro Elemento: "+fila.primeiro());
//        System.out.println("Tamanho da fila: "+fila.tamanho());
//        System.out.println("Saiu da Fila: "+ fila.desenfileirar());
//        System.out.println("Primeiro Elemento: "+fila.primeiro());
//        System.out.println("Tamanho da fila: "+fila.tamanho());

        FilaSimples<String> filaSimples = new FilaSimples<>(50);
        filaSimples.enfileirar("7");
        filaSimples.enfileirar("10");
        filaSimples.enfileirar("6");
        filaSimples.printFila();
        System.out.println("Tamanho: "+filaSimples.tamanho());
        filaSimples.enfileirar("A");
        filaSimples.enfileirar("B");
        filaSimples.enfileirar("C");
        filaSimples.printFila();
        System.out.println("Tamanho: "+filaSimples.tamanho());
        System.out.println("Retirado: "+filaSimples.desenfileirar());
        filaSimples.printFila();
        System.out.println("Tamanho: "+filaSimples.tamanho());
        filaSimples.desenfileirar();
        filaSimples.desenfileirar();
        filaSimples.desenfileirar();
        filaSimples.desenfileirar();
        filaSimples.desenfileirar();
        filaSimples.printFila();

    }
}