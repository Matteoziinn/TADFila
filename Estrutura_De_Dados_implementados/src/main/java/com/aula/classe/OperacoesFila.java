package com.aula.classe;

import com.aula.iClasse.Fila;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class OperacoesFila {

    // 1. Rotacionar k posições para a esquerda
    public static void rotacionarEsquerda(Fila<Integer> f, int k) {
        if (f == null || f.vazia() || k <= 0) return;
        int n = f.tamanho();
        k = k % n;
        for (int i = 0; i < k; i++) {
            Integer x = f.desenfileirar();
            if (x != null) f.enfileirar(x);
        }
    }

    // 2. Inverter os primeiros k elementos usando pilha auxiliar
    public static void inverterPrimeirosK(Fila<Integer> f, int k) {
        if (f == null || f.vazia() || k <= 0) return;
        int n = f.tamanho();
        if (k > n) k = n;
        Stack<Integer> pilha = new Stack<>();

        for (int i = 0; i < k; i++) {
            Integer x = f.desenfileirar();
            pilha.push(x);
        }

        while (!pilha.isEmpty()) {
            f.enfileirar(pilha.pop());
        }

        int rest = n - k;
        for (int i = 0; i < rest; i++) {
            f.enfileirar(f.desenfileirar());
        }
    }

    // 3. Intercalar duas filas A e B em C sem deixar A e B alteradas ao final
    public static Fila<Integer> intercalar(Fila<Integer> A, Fila<Integer> B) {
        Fila<Integer> C = new FilaSimples<>();
        Fila<Integer> tempA = new FilaSimples<>();
        Fila<Integer> tempB = new FilaSimples<>();


        while (!A.vazia() || !B.vazia()) {
            if (!A.vazia()) {
                Integer a = A.desenfileirar();
                C.enfileirar(a);
                tempA.enfileirar(a);
            }
            if (!B.vazia()) {
                Integer b = B.desenfileirar();
                C.enfileirar(b);
                tempB.enfileirar(b);
            }
        }
        while (!tempA.vazia()) A.enfileirar(tempA.desenfileirar());
        while (!tempB.vazia()) B.enfileirar(tempB.desenfileirar());

        return C;
    }

    // 4. Verificar igualdade de duas filas de String sem modificar no final
    public static boolean filasIguais(Fila<String> f1, Fila<String> f2) {
        if (f1 == null || f2 == null) return false;
        if (f1.tamanho() != f2.tamanho()) return false;
        int n = f1.tamanho();
        boolean iguais = true;
        for (int i = 0; i < n; i++) {
            String s1 = f1.desenfileirar();
            String s2 = f2.desenfileirar();
            if (s1 == null ? s2 != null : !s1.equals(s2)) {
                iguais = false;
            }
            f1.enfileirar(s1);
            f2.enfileirar(s2);
        }
        return iguais;
    }

    // 5. Remover duplicados (preservando primeira ocorrência) usando HashSet
    public static void removerDuplicados(Fila<Integer> f) {
        if (f == null || f.vazia()) return;
        HashSet<Integer> seen = new HashSet<>();
        int n = f.tamanho();
        for (int i = 0; i < n; i++) {
            Integer x = f.desenfileirar();
            if (!seen.contains(x)) {
                seen.add(x);
                f.enfileirar(x);
            }
        }
    }

    public static class Cliente {
        public String nome;
        public int tempoAtendimento;
        public Cliente(String nome, int tempo) { this.nome = nome; this.tempoAtendimento = tempo; }
        public String toString() { return nome + "(" + tempoAtendimento + ")"; }
    }

    // 6. Simulação de atendimento em caixa
    public static double simularAtendimento(Fila<Cliente> chegada) {
        if (chegada == null || chegada.vazia()) return 0.0;
        int totalClientes = chegada.tamanho();
        int tempoTotal = 0;
        System.out.println("Ordem de atendimento:");
        List<String> ordem = new ArrayList<>();
        while (!chegada.vazia()) {
            Cliente c = chegada.desenfileirar();
            System.out.println("Atendendo: " + c);
            tempoTotal += c.tempoAtendimento;
            ordem.add(c.nome);
        }
        double media = (double) tempoTotal / (double) totalClientes;
        System.out.println("Tempo total = " + tempoTotal + ", Tempo médio = " + media);
        return media;
    }

    public static class Evento {
        public String nome;
        public int tempo;
        public Evento(String nome, int tempo) { this.nome = nome; this.tempo = tempo; }
        public String toString() { return nome + "(" + tempo + ")"; }
    }

    // 7. Mesclar duas filas de eventos ordenadas por tempo (estável: prioridade para primeira fila no empate)
    public static Fila<Evento> mesclarEventosPorTempo(Fila<Evento> f1, Fila<Evento> f2) {
        Fila<Evento> res = new FilaSimples<>();
        Fila<Evento> temp1 = new FilaSimples<>();
        Fila<Evento> temp2 = new FilaSimples<>();

        while (!f1.vazia() && !f2.vazia()) {
            Evento e1 = f1.primeiro();
            Evento e2 = f2.primeiro();
            if (e1.tempo <= e2.tempo) {
                Evento x = f1.desenfileirar();
                res.enfileirar(x);
                temp1.enfileirar(x);
            } else {
                Evento y = f2.desenfileirar();
                res.enfileirar(y);
                temp2.enfileirar(y);
            }
        }
        while (!f1.vazia()) {
            Evento x = f1.desenfileirar();
            res.enfileirar(x);
            temp1.enfileirar(x);
        }
        while (!f2.vazia()) {
            Evento y = f2.desenfileirar();
            res.enfileirar(y);
            temp2.enfileirar(y);
        }
        while (!temp1.vazia()) f1.enfileirar(temp1.desenfileirar());
        while (!temp2.vazia()) f2.enfileirar(temp2.desenfileirar());

        return res;
    }

    // 8. Gerador de números binários de 1 até N usando fila
    public static List<String> gerarBinarios(int N) {
        List<String> saida = new ArrayList<>();
        if (N <= 0) return saida;

        Fila<String> q = new FilaSimples<>(2 * N + 5);

        q.enfileirar("1");
        while (saida.size() < N) {
            String s = q.desenfileirar();
            saida.add(s);
            q.enfileirar(s + "0");
            q.enfileirar(s + "1");
        }
        return saida;
    }


    // 9. Mesclar duas filas de inteiros ordenadas em C (mantendo A e B vazias? The spec says do not use arrays.)
    public static Fila<Integer> mesclarFilasOrdenadas(Fila<Integer> A, Fila<Integer> B) {
        Fila<Integer> C = new FilaSimples<>();
        Fila<Integer> tempA = new FilaSimples<>();
        Fila<Integer> tempB = new FilaSimples<>();
        while (!A.vazia() && !B.vazia()) {
            Integer a = A.primeiro();
            Integer b = B.primeiro();
            if (a <= b) {
                Integer x = A.desenfileirar();
                C.enfileirar(x);
                tempA.enfileirar(x);
            } else {
                Integer y = B.desenfileirar();
                C.enfileirar(y);
                tempB.enfileirar(y);
            }
        }
        while (!A.vazia()) {
            Integer x = A.desenfileirar();
            C.enfileirar(x);
            tempA.enfileirar(x);
        }
        while (!B.vazia()) {
            Integer y = B.desenfileirar();
            C.enfileirar(y);
            tempB.enfileirar(y);
        }
        while (!tempA.vazia()) A.enfileirar(tempA.desenfileirar());
        while (!tempB.vazia()) B.enfileirar(tempB.desenfileirar());
        return C;
    }

    // 10. Espelhar fila: concatenar uma cópia dela mesma ao final.
    public static <T> void espelharFila(Fila<T> f) {
        if (f == null || f.vazia()) return;
        int n = f.tamanho();
        Fila<T> aux = new FilaSimples<>();
        for (int i = 0; i < n; i++) {
            T x = f.desenfileirar();
            f.enfileirar(x);
            aux.enfileirar(x);
        }
        for (int i = 0; i < n; i++) {
            f.enfileirar(aux.desenfileirar());
        }
    }
}
