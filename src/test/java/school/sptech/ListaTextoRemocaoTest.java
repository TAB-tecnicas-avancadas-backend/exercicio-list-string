package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static school.sptech.TestReflectionUtils.*;

@DisplayName("ListaTexto — Remoção")
class ListaTextoRemocaoTest {

    // ========================
    // remove(int)
    // ========================

    @Test
    @DisplayName("remove(int) — índice no meio — retorna o elemento e demais permanecem em ordem")
    void removeIndexado_indiceNoMeio_retornaElementoEDemaisEmOrdem() {
        var lista = new ListaTexto();
        var arr = newArray(6);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "C"; arr[3] = "D"; arr[4] = "E";
        preload(lista, arr, 5);

        String removido = lista.remove(2);

        assertEquals("C", removido);
        assertEquals(4, numElements(lista));
        String[] a = elements(lista);
        assertEquals("A", a[0]); assertEquals("B", a[1]);
        assertEquals("D", a[2]); assertEquals("E", a[3]);
    }

    @Test
    @DisplayName("remove(int) — índice 0 — retorna o primeiro elemento e demais permanecem em ordem")
    void removeIndexado_indicePrimeiro_retornaPrimeiroEDemaisEmOrdem() {
        var lista = new ListaTexto();
        var arr = newArray(5);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "C";
        preload(lista, arr, 3);

        String removido = lista.remove(0);

        assertEquals("A", removido);
        assertEquals(2, numElements(lista));
        assertEquals("B", elements(lista)[0]);
        assertEquals("C", elements(lista)[1]);
    }

    @Test
    @DisplayName("remove(int) — último índice válido — retorna o elemento e tamanho decrementado")
    void removeIndexado_indiceUltimo_retornaElementoETamanhoDecrementado() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "C";
        preload(lista, arr, 3);

        String removido = lista.remove(2);

        assertEquals("C", removido);
        assertEquals(2, numElements(lista));
        assertNull(elements(lista)[2]);
    }

    @Test
    @DisplayName("remove(int) — índice fora do intervalo [0, size) — lança IndexOutOfBoundsException")
    void removeIndexado_indiceInvalido_lancaIndexOutOfBoundsException() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(0));

        preload(lista, newArray(4), 2);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(-1));
    }

    // ========================
    // remove(String)
    // ========================

    @Test
    @DisplayName("remove(String) — elemento com duplicata — remove somente a primeira ocorrência")
    void removeElemento_comDuplicata_removeSomentePrimeiraOcorrencia() {
        var lista = new ListaTexto();
        var arr = newArray(6);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "X"; arr[3] = "X"; arr[4] = "C";
        preload(lista, arr, 5);

        assertTrue(lista.remove("X"));

        assertEquals(4, numElements(lista));
        String[] a = elements(lista);
        assertEquals("A", a[0]); assertEquals("B", a[1]);
        assertEquals("X", a[2]);
        assertEquals("C", a[3]);
    }

    @Test
    @DisplayName("remove(String) — elemento inexistente — retorna false e lista inalterada")
    void removeElemento_inexistente_retornaFalseEListaInalterada() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A"; arr[1] = "B";
        preload(lista, arr, 2);

        assertFalse(lista.remove("Z"));

        assertEquals(2, numElements(lista));
        assertEquals("A", elements(lista)[0]);
        assertEquals("B", elements(lista)[1]);
    }

    @Test
    @DisplayName("remove(String) — null presente com duplicata — remove somente a primeira ocorrência de null")
    void removeElemento_nullComDuplicata_removeSomeitePrimeiraOcorrencia() {
        var lista = new ListaTexto();
        var arr = newArray(5);
        arr[0] = null; arr[1] = "A"; arr[2] = null;
        preload(lista, arr, 3);

        assertTrue(lista.remove(null));

        assertEquals(2, numElements(lista));
        assertEquals("A", elements(lista)[0]);
        assertNull(elements(lista)[1]);
    }

    // ========================
    // clear()
    // ========================

    @Test
    @DisplayName("clear — lista com elementos — tamanho zero e capacidade preservada")
    void clear_listaComElementos_tamanhoZeroECapacidadePreservada() {
        var lista = new ListaTexto();
        var arr = newArray(8);
        arr[0] = "A"; arr[1] = "B";
        preload(lista, arr, 2);

        lista.clear();

        assertEquals(0, numElements(lista));
        assertEquals(8, elements(lista).length);
    }

    @Test
    @DisplayName("clear — lista com elementos — nenhum elemento acessível após a operação")
    void clear_listaComElementos_nenhumElementoAcessivel() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "C";
        preload(lista, arr, 3);

        lista.clear();

        String[] interno = elements(lista);
        assertNull(interno[0]);
        assertNull(interno[1]);
        assertNull(interno[2]);
    }

    @Test
    @DisplayName("clear — lista já vazia — estado permanece inalterado")
    void clear_listaJaVazia_estadoPermanecInalterado() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        lista.clear();

        assertEquals(0, numElements(lista));
        assertEquals(4, elements(lista).length);
    }
}
