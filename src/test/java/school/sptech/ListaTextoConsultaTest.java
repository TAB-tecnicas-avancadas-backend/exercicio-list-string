package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static school.sptech.TestReflectionUtils.*;

@DisplayName("ListaTexto — Consulta")
class ListaTextoConsultaTest {

    // ========================
    // contains(String)
    // ========================

    @Test
    @DisplayName("contains — elemento presente na lista — retorna true")
    void contains_elementoPresente_retornaTrue() {
        var lista = new ListaTexto();
        var arr = newArray(5);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "C";
        preload(lista, arr, 3);

        assertTrue(lista.contains("B"));
    }

    @Test
    @DisplayName("contains — elemento ausente da lista — retorna false")
    void contains_elementoAusente_retornaFalse() {
        var lista = new ListaTexto();
        var arr = newArray(5);
        arr[0] = "A"; arr[1] = "B";
        preload(lista, arr, 2);

        assertFalse(lista.contains("Z"));
    }

    @Test
    @DisplayName("contains — null presente — retorna true; outro elemento ausente — retorna false")
    void contains_nullPresente_retornaTrueParaNullEFalseParaOutro() {
        var lista = new ListaTexto();
        var arr = newArray(5);
        arr[0] = null; arr[1] = "X";
        preload(lista, arr, 2);

        assertTrue(lista.contains(null));
        assertFalse(lista.contains("Y"));
    }

    // ========================
    // indexOf(String)
    // ========================

    @Test
    @DisplayName("indexOf — elemento com duplicata — retorna índice da primeira ocorrência")
    void indexOf_elementoComDuplicata_retornaPrimeiroIndice() {
        var lista = new ListaTexto();
        var arr = newArray(6);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "B"; arr[3] = "C";
        preload(lista, arr, 4);

        assertEquals(1, lista.indexOf("B"));
    }

    @Test
    @DisplayName("indexOf — elemento ausente — retorna -1")
    void indexOf_elementoAusente_retornaMenosUm() {
        var lista = new ListaTexto();
        preload(lista, newArray(4), 0);

        assertEquals(-1, lista.indexOf("X"));
    }

    @Test
    @DisplayName("indexOf — null com duplicata — retorna índice do primeiro null")
    void indexOf_nullComDuplicata_retornaPrimeiroIndiceNull() {
        var lista = new ListaTexto();
        var arr = newArray(5);
        arr[0] = null; arr[1] = "A"; arr[2] = null;
        preload(lista, arr, 3);

        assertEquals(0, lista.indexOf(null));
    }

    @Test
    @DisplayName("indexOf — busca não deve ultrapassar numElements (slots além do tamanho são ignorados)")
    void indexOf_naoBuscaAlemDeNumElements() {
        var lista = new ListaTexto();
        var arr = newArray(6);
        arr[0] = "A"; arr[1] = "B";
        // arr[2] = "C" propositalmente fora dos elementos válidos
        arr[2] = "C";
        preload(lista, arr, 2); // size = 2, "C" está no array mas fora dos limites

        assertEquals(-1, lista.indexOf("C"),
                "indexOf não deve considerar slots além de numElements");
    }

    // ========================
    // lastIndexOf(String)
    // ========================

    @Test
    @DisplayName("lastIndexOf — elemento com múltiplas ocorrências — retorna índice da última")
    void lastIndexOf_elementoComMultiplasOcorrencias_retornaUltimoIndice() {
        var lista = new ListaTexto();
        var arr = newArray(6);
        arr[0] = "A"; arr[1] = "B"; arr[2] = "B"; arr[3] = "C"; arr[4] = "B";
        preload(lista, arr, 5);

        assertEquals(4, lista.lastIndexOf("B"));
    }

    @Test
    @DisplayName("lastIndexOf — elemento ausente — retorna -1")
    void lastIndexOf_elementoAusente_retornaMenosUm() {
        var lista = new ListaTexto();
        var arr = newArray(3);
        arr[0] = "A";
        preload(lista, arr, 1);

        assertEquals(-1, lista.lastIndexOf("Z"));
    }

    @Test
    @DisplayName("lastIndexOf — null com duplicata — retorna índice do último null")
    void lastIndexOf_nullComDuplicata_retornaUltimoIndiceNull() {
        var lista = new ListaTexto();
        var arr = newArray(5);
        arr[0] = null; arr[1] = "A"; arr[2] = null;
        preload(lista, arr, 3);

        assertEquals(2, lista.lastIndexOf(null));
    }
}
