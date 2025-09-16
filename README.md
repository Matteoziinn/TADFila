# Estrutura de Dados - Fila (TAD)

Este projeto foi desenvolvido como parte da disciplina **Estrutura de Dados**, com foco na implementação e uso do **TAD Fila** em Java.  
O código utiliza uma **interface `Fila<T>`**, e suas implementações **`FilaSimples`** (baseada em array circular) e **`FilaEncadeada`** (baseada em lista encadeada).

## 📌 Funcionalidades Implementadas

Foram implementados e testados os seguintes procedimentos:

1. **Rotacionar fila**  
   Rotaciona os elementos `k` posições para a esquerda.  

2. **Inverter os primeiros k elementos**  
   Inverte apenas os `k` primeiros itens da fila, mantendo o restante.  

3. **Intercalar duas filas**  
   Alterna elementos de A e B em uma nova fila C.  

4. **Comparar filas**  
   Verifica se duas filas de strings são iguais em conteúdo e ordem.  

5. **Remover duplicados**  
   Remove elementos repetidos, preservando a primeira ocorrência.  

6. **Simulação de atendimento em banco**  
   Atende clientes enfileirados (nome, tempo de atendimento), mostrando ordem, tempo total e tempo médio.  

7. **Mesclar filas de eventos**  
   Mescla duas filas de eventos `(nome, tempo)` em ordem crescente de tempo.  

8. **Gerador de números binários (1..N)**  
   Gera todos os números binários de 1 até N usando fila.  

9. **Mesclar filas ordenadas**  
   Une duas filas de inteiros já ordenadas em uma terceira fila também ordenada.  

10. **Espelhar fila**  
   Duplica os elementos da fila, concatenando uma cópia ao final.  

---

## 🚀 Como executar

### Compilação e execução manual (sem Maven)
Na raiz do projeto:

```bash
# Compilar todas as classes
mkdir -p bin
javac -d bin $(find src/main/java -name "*.java")

# Executar os testes
java -cp bin com.aula.TesteOperacoesFila
Execução da Main (exemplo simples)
bash
Copiar código
java -cp bin com.aula.Main
⚠️ Atenção: a classe Main é apenas um exemplo didático.
Para verificar todos os exercícios implementados, rode TesteOperacoesFila.

✅ Saída esperada dos testes
Ao rodar TesteOperacoesFila, a saída será semelhante a:

yaml
Copiar código
==== Testes OperacoesFila ====
Antes rotacao: 
Impressão da Fila: 
1 - 2 - 3 - 4 - 5
Depois rotacao (k=2): 
Impressão da Fila: 
3 - 4 - 5 - 1 - 2
...
Depois espelhar: 
Impressão da Fila: 
1 - 2 - 3 - 1 - 2 - 3
==== Fim dos testes ====
📂 Estrutura do projeto
bash
Copiar código
src/main/java/com/aula/
 ├── Main.java
 ├── TesteOperacoesFila.java   # Classe de testes principais
 ├── classe/
 │    ├── FilaSimples.java     # Implementação com array circular
 │    ├── FilaEncadeada.java   # Implementação encadeada
 │    └── OperacoesFila.java   # Exercícios implementados
 └── iClasse/
      └── Fila.java            # Interface da fila
📝 Autor
Trabalho desenvolvido como parte da disciplina Estrutura de Dados (TAD - Fila)
Curso: Análise e Desenvolvimento de Sistemas
