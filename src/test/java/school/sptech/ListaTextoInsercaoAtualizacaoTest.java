package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static school.sptech.TestReflectionUtils.*;

@DisplayName("ListaTexto — Inserção e Atualização")
class ListaTextoInsercaoAtualizacaoTest {

    // ========================
    // add(String)
    // ========================

    @Test
    @DisplayName("add(String) — lista com espaço livre — elemento inserido ao final e tamanho incrementado")
    void add_comEspacoLivre_elementoNoFinalETamanhoAtualizado() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A";
        arr[1] = "B";
        preload(lista, arr, 2);

        assertTrue(lista.add("C"));

        assertEquals(3, numElements(lista));
        assertEquals("C", elements(lista)[2]);
    }

    @Test
    @DisplayName("add(String) — lista cheia — todos os elementos preservados em ordem e novo elemento ao final")
    void add_listaCheia_elementosPreservadosENovoAoFinal() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "C"; arr[3] = "D";
        preload(lista, arr, 4);

        assertTrue(lista.add("E"));

        String[] novo = elements(lista);
        assertTrue(novo.length > 4);
        assertEquals(5, numElements(lista));
        assertEquals("A", novo[0]); assertEquals("B", novo[1]);
        assertEquals("C", novo[2]); assertEquals("D", novo[3]);
        assertEquals("E", novo[4]);
    }

    @Test
    @DisplayName("add(String) — elemento null — aceita e registra corretamente")
    void add_elementoNull_aceitaERegistra() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "X";
        preload(lista, arr, 1);

        assertTrue(lista.add(null));

        assertEquals(2, numElements(lista));
        assertNull(elements(lista)[1]);
    }

    // ========================
    // add(int, String)
    // ========================

    @Test
    @DisplayName("add(int, String) — índice no meio — elemento na posição correta e demais em ordem")
    void addIndexado_indiceNoMeio_elementoNaPosicaoEDemaisEmOrdem() {
        var lista = new ListaTexto();
        var arr = newArray(6);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "D"; arr[3] = "E";
        preload(lista, arr, 4);

        lista.add(2, "C");

        String[] a = elements(lista);
        assertEquals(5, numElements(lista));
        assertEquals("A", a[0]);
        assertEquals("B", a[1]);
        assertEquals("C", a[2]);
        assertEquals("D", a[3]);
        assertEquals("E", a[4]);
    }

    @Test
    @DisplayName("add(int, String) — índice igual ao tamanho — elemento inserido ao final")
    void addIndexado_indiceIgualAoTamanho_elementoAoFinal() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A";
        preload(lista, arr, 1);

        lista.add(1, "B");

        assertEquals(2, numElements(lista));
        assertEquals("A", elements(lista)[0]);
        assertEquals("B", elements(lista)[1]);
    }

    @Test
    @DisplayName("add(int, String) — índice 0 — elemento no início e demais em ordem")
    void addIndexado_indiceZero_elementoNoInicioEDemaisEmOrdem() {
        var lista = new ListaTexto();
        var arr = newArray(5);
        arr[0] = "B"; arr[1] = "C";
        preload(lista, arr, 2);

        lista.add(0, "A");

        String[] a = elements(lista);
        assertEquals(3, numElements(lista));
        assertEquals("A", a[0]);
        assertEquals("B", a[1]);
        assertEquals("C", a[2]);
    }

    @Test
    @DisplayName("add(int, String) — índice fora do intervalo [0, size] — lança IndexOutOfBoundsException")
    void addIndexado_indiceInvalido_lancaIndexOutOfBoundsException() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.add(-1, "X"));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.add(1, "X"));

        preload(lista, newArray(4), 2);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.add(3, "X"));
    }

    // ========================
    // addAll(ListaTexto)
    // ========================

    @Test
    @DisplayName("addAll — origem não vazia — elementos inseridos em ordem e retorna true")
    void addAll_origemNaoVazia_elementosEmOrdemERetornaTrue() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        var origem = new ListaTexto();
        var arrOrigem = newArray(4);
        arrOrigem[0] = "A"; arrOrigem[1] = "B";
        preload(origem, arrOrigem, 2);

        assertTrue(lista.addAll(origem));

        assertEquals(2, numElements(lista));
        assertEquals("A", elements(lista)[0]);
        assertEquals("B", elements(lista)[1]);
    }

    @Test
    @DisplayName("addAll — origem vazia — lista inalterada e retorna false")
    void addAll_origemVazia_listaInarteradaERetornaFalse() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        var origem = new ListaTexto();
        preload(origem, newArray(4), 0);

        assertFalse(lista.addAll(origem));
        assertEquals(0, numElements(lista));
    }

    @Test
    @DisplayName("addAll — origem com muitos elementos — ordem de ambas as listas preservada")
    void addAll_origemComMuitosElementos_ordemPreservada() {
        var lista = new ListaTexto();
        var inicial = newArray(4);
        inicial[0] = "X";
        preload(lista, inicial, 1);

        var origem = new ListaTexto();
        var arrOrigem = newArray(8);
        arrOrigem[0] = "A"; arrOrigem[1] = "B"; arrOrigem[2] = "C"; arrOrigem[3] = "D";
        arrOrigem[4] = "E"; arrOrigem[5] = "F"; arrOrigem[6] = "G";
        preload(origem, arrOrigem, 7);

        assertTrue(lista.addAll(origem));

        String[] resultado = elements(lista);
        assertEquals(8, numElements(lista));
        assertEquals("X", resultado[0]);
        assertEquals("A", resultado[1]);
        assertEquals("G", resultado[7]);
    }

    // ========================
    // set(int, String)
    // ========================

    @Test
    @DisplayName("set — índice válido — retorna valor anterior e posição contém o novo valor")
    void set_indiceValido_retornaAntigoEPosicaoAtualizada() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A"; arr[1] = "B";
        preload(lista, arr, 2);

        String antigo = lista.set(1, "BB");

        assertEquals("B", antigo);
        assertEquals("BB", elements(lista)[1]);
        assertEquals(2, numElements(lista));
    }

    @Test
    @DisplayName("set — novo valor null — retorna valor anterior e posição contém null")
    void set_novoValorNull_retornaAntigoEPosicaoNull() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A";
        preload(lista, arr, 1);

        String antigo = lista.set(0, null);

        assertEquals("A", antigo);
        assertNull(elements(lista)[0]);
        assertEquals(1, numElements(lista));
    }

    @Test
    @DisplayName("set — índice fora do intervalo [0, size) — lança IndexOutOfBoundsException")
    void set_indiceInvalido_lancaIndexOutOfBoundsException() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.set(0, "X"));

        preload(lista, newArray(4), 2);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.set(2, "X"));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.set(-1, "X"));
    }
}
