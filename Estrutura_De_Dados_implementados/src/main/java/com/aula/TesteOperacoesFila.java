package com.aula;

import com.aula.classe.*;
import com.aula.iClasse.Fila;

import java.util.List;

public class TesteOperacoesFila {
    public static void main(String[] args) {
        System.out.println("==== Testes OperacoesFila ====");

        // Test 1: Rotacionar esquerda
        Fila<Integer> f1 = new FilaSimples<>();
        f1.enfileirar(1); f1.enfileirar(2); f1.enfileirar(3); f1.enfileirar(4); f1.enfileirar(5);
        System.out.println("Antes rotacao: "); ((FilaSimples<Integer>)f1).printFila();
        OperacoesFila.rotacionarEsquerda(f1, 2);
        System.out.println("Depois rotacao (k=2): "); ((FilaSimples<Integer>)f1).printFila();

        // Test 2: Inverter primeiros K
        Fila<Integer> f2 = new FilaSimples<>();
        for (int i=1;i<=6;i++) f2.enfileirar(i);
        System.out.println("Antes inverterK: "); ((FilaSimples<Integer>)f2).printFila();
        OperacoesFila.inverterPrimeirosK(f2, 3);
        System.out.println("Depois inverterK k=3: "); ((FilaSimples<Integer>)f2).printFila();

        // Test 3: Intercalar sem modificar originais
        Fila<Integer> A = new FilaSimples<>();
        Fila<Integer> B = new FilaSimples<>();
        A.enfileirar(1); A.enfileirar(3); A.enfileirar(5);
        B.enfileirar(2); B.enfileirar(4); B.enfileirar(6); B.enfileirar(8);
        System.out.println("A antes: "); ((FilaSimples<Integer>)A).printFila();
        System.out.println("B antes: "); ((FilaSimples<Integer>)B).printFila();
        Fila<Integer> C = OperacoesFila.intercalar(A,B);
        System.out.println("C intercalada: "); ((FilaSimples<Integer>)C).printFila();
        System.out.println("A depois (deve ser igual ao inicial): "); ((FilaSimples<Integer>)A).printFila();
        System.out.println("B depois (deve ser igual ao inicial): "); ((FilaSimples<Integer>)B).printFila();

        // Test 4: Filas iguais
        Fila<String> s1 = new FilaSimples<>();
        Fila<String> s2 = new FilaSimples<>();
        s1.enfileirar("x"); s1.enfileirar("y"); s1.enfileirar("z");
        s2.enfileirar("x"); s2.enfileirar("y"); s2.enfileirar("z");
        System.out.println("Filas iguais? " + OperacoesFila.filasIguais(s1,s2));
        System.out.println("s1 depois: "); ((FilaSimples<String>)s1).printFila();
        System.out.println("s2 depois: "); ((FilaSimples<String>)s2).printFila();

        // Test 5: Remover duplicados
        Fila<Integer> f5 = new FilaSimples<>();
        f5.enfileirar(1); f5.enfileirar(2); f5.enfileirar(1); f5.enfileirar(3); f5.enfileirar(2); f5.enfileirar(4);
        System.out.println("Antes removerDuplicados: "); ((FilaSimples<Integer>)f5).printFila();
        OperacoesFila.removerDuplicados(f5);
        System.out.println("Depois removerDuplicados: "); ((FilaSimples<Integer>)f5).printFila();

        // Test 6: Simulacao de atendimento
        Fila<OperacoesFila.Cliente> chegada = new FilaSimples<>();
        chegada.enfileirar(new OperacoesFila.Cliente("Alice", 5));
        chegada.enfileirar(new OperacoesFila.Cliente("Bob", 3));
        chegada.enfileirar(new OperacoesFila.Cliente("Carol", 7));
        OperacoesFila.simularAtendimento(chegada); // imprime ordem e media

        // Test 7: Mesclar eventos por tempo
        Fila<OperacoesFila.Evento> e1 = new FilaSimples<>();
        Fila<OperacoesFila.Evento> e2 = new FilaSimples<>();
        e1.enfileirar(new OperacoesFila.Evento("E1", 1));
        e1.enfileirar(new OperacoesFila.Evento("E3", 5));
        e2.enfileirar(new OperacoesFila.Evento("E2", 3));
        e2.enfileirar(new OperacoesFila.Evento("E4", 5));
        Fila<OperacoesFila.Evento> me = OperacoesFila.mesclarEventosPorTempo(e1,e2);
        System.out.println("Eventos mesclados: "); ((FilaSimples<OperacoesFila.Evento>)me).printFila();

        // Test 8: Gerador binario
        List<String> bins = OperacoesFila.gerarBinarios(10);
        System.out.println("Binarios 1..10: " + bins);

        // Test 9: Mesclar duas filas ordenadas de inteiros
        Fila<Integer> fa = new FilaSimples<>();
        Fila<Integer> fb = new FilaSimples<>();
        fa.enfileirar(1); fa.enfileirar(4); fa.enfileirar(7);
        fb.enfileirar(2); fb.enfileirar(3); fb.enfileirar(5); fb.enfileirar(9);
        Fila<Integer> fc = OperacoesFila.mesclarFilasOrdenadas(fa, fb);
        System.out.println("Filas mescladas ordenadas: "); ((FilaSimples<Integer>)fc).printFila();
        System.out.println("fa depois: "); ((FilaSimples<Integer>)fa).printFila();
        System.out.println("fb depois: "); ((FilaSimples<Integer>)fb).printFila();

        // Test 10: Espelhar fila
        Fila<Integer> f10 = new FilaSimples<>();
        f10.enfileirar(1); f10.enfileirar(2); f10.enfileirar(3);
        System.out.println("Antes espelhar: "); ((FilaSimples<Integer>)f10).printFila();
        OperacoesFila.espelharFila(f10);
        System.out.println("Depois espelhar: "); ((FilaSimples<Integer>)f10).printFila();

        System.out.println("==== Fim dos testes ====");
    }
}
