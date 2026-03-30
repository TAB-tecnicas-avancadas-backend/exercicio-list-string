package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static school.sptech.TestReflectionUtils.*;

@DisplayName("ListaTexto — Representação")
class ListaTextoRepresentacaoTest {

    // ========================
    // toString()
    // ========================

    @Test
    @DisplayName("toString — lista vazia — retorna []")
    void toString_listaVazia_retornaColchetesVazios() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        assertEquals("[]", lista.toString());
    }

    @Test
    @DisplayName("toString — lista com um elemento — retorna [elemento]")
    void toString_umElemento_retornaElementoEntreColchetes() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A";
        preload(lista, arr, 1);

        assertEquals("[A]", lista.toString());
    }

    @Test
    @DisplayName("toString — lista com múltiplos elementos — retorna elementos separados por vírgula e espaço")
    void toString_multiplosElementos_retornaFormatoCorreto() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "C";
        preload(lista, arr, 3);

        assertEquals("[A, B, C]", lista.toString());
    }

    @Test
    @DisplayName("toString — lista com elemento null — exibe null como texto")
    void toString_comNull_exibeNullComoTexto() {
        var lista = new ListaTexto();
        var arr = newArray(4);
        arr[0] = "A"; arr[1] = null; arr[2] = "B";
        preload(lista, arr, 3);

        assertEquals("[A, null, B]", lista.toString());
    }
}
