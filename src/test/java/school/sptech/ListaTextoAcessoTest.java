package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static school.sptech.TestReflectionUtils.*;

@DisplayName("ListaTexto — Acesso")
class ListaTextoAcessoTest {

    // ========================
    // get(int)
    // ========================

    @Test
    @DisplayName("get — índice válido — retorna o elemento armazenado naquela posição")
    void get_indiceValido_retornaElementoCorreto() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A"; arr[1] = "B";
        preload(lista, arr, 2);

        assertEquals("A", lista.get(0));
        assertEquals("B", lista.get(1));
    }

    @Test
    @DisplayName("get — índice negativo ou >= size — lança IndexOutOfBoundsException")
    void get_indiceInvalido_lancaIndexOutOfBoundsException() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(0),
                "lista vazia: índice 0 é inválido");

        preload(lista, newArray(4), 1);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(1),
                "índice == size() é inválido");
        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(-1),
                "índice negativo é inválido");
    }

    @Test
    @DisplayName("get — elemento null armazenado — retorna null sem lançar exceção")
    void get_elementoNullArmazenado_retornaNullSemExcecao() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = null;
        preload(lista, arr, 1);

        assertNull(lista.get(0));
    }

    // ========================
    // size()
    // ========================

    @Test
    @DisplayName("size — lista vazia — retorna 0")
    void size_listaVazia_retornaZero() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        assertEquals(0, lista.size());
    }

    @Test
    @DisplayName("size — lista com elementos — retorna a quantidade correta")
    void size_numElementsConfigurado_retornaNumElements() {
        var lista = new ListaTexto();
        preload(lista, newArray(10), 7);

        assertEquals(7, lista.size());
    }

    @Test
    @DisplayName("size — lista com menos elementos que a capacidade — retorna a quantidade de elementos, não a capacidade")
    void size_capacidadeMaiorQueNumElements_naoRetornaCapacidade() {
        var lista = new ListaTexto();
        preload(lista, newArray(10), 3);

        assertEquals(3, lista.size());
        assertNotEquals(10, lista.size());
    }

    // ========================
    // isEmpty()
    // ========================

    @Test
    @DisplayName("isEmpty — lista vazia — retorna true")
    void isEmpty_numElementsZero_retornaTrue() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        assertTrue(lista.isEmpty());
    }

    @Test
    @DisplayName("isEmpty — lista com elementos — retorna false")
    void isEmpty_numElementsMaiorQueZero_retornaFalse() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 1);

        assertFalse(lista.isEmpty());
    }

    @Test
    @DisplayName("isEmpty — lista vazia com grande capacidade alocada — retorna true")
    void isEmpty_grandeCapacidadeComNumElementsZero_retornaTrue() {
        var lista = new ListaTexto();
        preload(lista, newArray(100), 0);

        assertTrue(lista.isEmpty());
    }
}
