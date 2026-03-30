<h1 style="text-align:center;">Rubber Duck Debugging</h1>

<h3 style="text-align:center; font-style:italic;">
Capítulo 1: Se você não consegue explicar, provavelmente você não entendeu... 🦆
</h3>

<div style="text-align:center;">
  <a href="https://rubberduckdebugging.com/" target="_blank">
    <img src="rubber.png" alt="Patinho de borracha" width="400"/>
  </a>
</div>

---

# O que é um `ArrayList` em Java?

Um `ArrayList` é uma lista baseada em array com tamanho gerenciado automaticamente. Ele mantém a **ordem de inserção**, permite **elementos duplicados** e valores **`null`**.

Principais características:

- **Acesso por índice** é O(1).
- **Inserção no fim** é O(1) amortizado.
- **Inserções e remoções no meio** custam O(n).
- Existe diferença entre **capacidade** (tamanho do array interno) e **tamanho lógico** (quantidade de elementos presentes).

---

# Enunciado

Implemente a classe `ListaTexto`, que simula um `ArrayList<String>` usando um array interno.

## Estrutura

A classe já possui dois campos privados:

- `String[] elements` — array que armazena os elementos.
- `int numElements` — quantidade de elementos presentes na lista.

A capacidade inicial é **4**. Quando necessário, a capacidade deve crescer para comportar novos elementos.

---

## Inserção

### `boolean add(String element)`

Insere o elemento ao final da lista. Retorna `true`.

---

### `void add(int index, String element)`

Insere o elemento na posição `index`. Os elementos existentes a partir dessa posição devem permanecer presentes e em ordem após a inserção.

Índice válido: `0 <= index <= size()`.
Fora desse intervalo: lança `IndexOutOfBoundsException`.

---

### `boolean addAll(ListaTexto other)`

Insere todos os elementos de `other` ao final desta lista, mantendo a ordem original.

Retorna `true` se ao menos um elemento foi inserido; `false` se `other` estiver vazia.

---

### `String set(int index, String element)`

Substitui o elemento na posição `index` pelo novo valor. Retorna o valor que estava na posição antes da substituição.

Índice válido: `0 <= index < size()`.
Fora desse intervalo: lança `IndexOutOfBoundsException`.

---

## Acesso

### `String get(int index)`

Retorna o elemento na posição `index`.

Índice válido: `0 <= index < size()`.
Fora desse intervalo: lança `IndexOutOfBoundsException`.

---

### `int size()`

Retorna a quantidade de elementos presentes na lista.

---

### `boolean isEmpty()`

Retorna `true` se a lista não contiver elementos.

---

## Remoção

### `String remove(int index)`

Remove o elemento na posição `index` e o retorna. Os demais elementos devem permanecer presentes e em ordem.

Índice válido: `0 <= index < size()`.
Fora desse intervalo: lança `IndexOutOfBoundsException`.

---

### `boolean remove(String element)`

Remove a primeira ocorrência do elemento informado. Suporta `null`.

Retorna `true` se o elemento foi encontrado e removido; `false` caso contrário.

---

### `void clear()`

Remove todos os elementos da lista. A capacidade interna não deve ser alterada.

---

## Consulta

### `boolean contains(String element)`

Retorna `true` se o elemento estiver presente na lista. Suporta `null`.

---

### `int indexOf(String element)`

Retorna o índice da primeira ocorrência do elemento, ou `-1` se não estiver presente. Suporta `null`.

---

### `int lastIndexOf(String element)`

Retorna o índice da última ocorrência do elemento, ou `-1` se não estiver presente. Suporta `null`.

---

## Representação

### `String toString()`

Retorna uma representação textual da lista no formato `[A, B, C]`. Lista vazia retorna `[]`.

---

## Sobre os testes

Os testes **não dependem de um método para testar outro**. O estado interno da lista (`elements` e `numElements`) é lido e escrito diretamente via *reflection*, sem passar por `add`, `get`, `size` ou qualquer outro método da classe. Isso significa que cada método é avaliado de forma independente: um `get` com bug não interfere nos testes de `remove`, por exemplo.
