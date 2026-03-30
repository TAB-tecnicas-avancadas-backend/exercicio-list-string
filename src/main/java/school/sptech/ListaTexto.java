package school.sptech;

import java.util.Objects;

public class ListaTexto {

    private String[] elements;
    private int numElements;

    public ListaTexto() {
        this.elements = new String[4];
        this.numElements = 0;
    }

    // -------------------------------
    // INSERÇÃO
    // -------------------------------

    /**
     * Insere o elemento ao final da lista.
     * A capacidade interna é gerenciada automaticamente.
     *
     * @return {@code true} sempre
     */
    public boolean add(String element) {
        return false;
    }

    /**
     * Insere o elemento na posição indicada.
     * Os elementos a partir dessa posição permanecem em ordem após o novo.
     * Índice válido: {@code 0 <= index <= size()}.
     *
     * @throws IndexOutOfBoundsException se {@code index < 0 || index > size()}
     */
    public void add(int index, String element) {
    }

    /**
     * Insere todos os elementos de {@code other} ao final desta lista, em ordem.
     *
     * @return {@code true} se ao menos um elemento foi inserido; {@code false} se {@code other} estiver vazia
     */
    public boolean addAll(ListaTexto other) {
        return false;
    }

    /**
     * Substitui o elemento na posição indicada pelo novo valor.
     * Índice válido: {@code 0 <= index < size()}.
     *
     * @return o valor que ocupava a posição antes da substituição
     * @throws IndexOutOfBoundsException se {@code index < 0 || index >= size()}
     */
    public String set(int index, String element) {
        return null;
    }

    // -------------------------------
    // ACESSO
    // -------------------------------

    /**
     * Retorna o elemento na posição indicada.
     * Índice válido: {@code 0 <= index < size()}.
     *
     * @throws IndexOutOfBoundsException se {@code index < 0 || index >= size()}
     */
    public String get(int index) {
        return null;
    }

    /**
     * Retorna a quantidade de elementos na lista.
     */
    public int size() {
        return 0;
    }

    /**
     * Retorna {@code true} se a lista não contiver elementos.
     */
    public boolean isEmpty() {
        return false;
    }

    // -------------------------------
    // REMOÇÃO
    // -------------------------------

    /**
     * Remove o elemento na posição indicada e o retorna.
     * A ordem dos demais elementos é preservada.
     * Índice válido: {@code 0 <= index < size()}.
     *
     * @return o elemento removido
     * @throws IndexOutOfBoundsException se {@code index < 0 || index >= size()}
     */
    public String remove(int index) {
        return null;
    }

    /**
     * Remove a primeira ocorrência do elemento informado. Suporta {@code null}.
     *
     * @return {@code true} se o elemento foi encontrado e removido; {@code false} caso contrário
     */
    public boolean remove(String element) {
        return false;
    }

    /**
     * Remove todos os elementos da lista. A capacidade interna não é alterada.
     */
    public void clear() {
    }

    // -------------------------------
    // CONSULTA
    // -------------------------------

    /**
     * Retorna {@code true} se o elemento informado estiver presente na lista. Suporta {@code null}.
     */
    public boolean contains(String element) {
        return false;
    }

    /**
     * Retorna o índice da primeira ocorrência do elemento, ou {@code -1} se não estiver presente.
     * Suporta {@code null}.
     */
    public int indexOf(String element) {
        return 0;
    }

    /**
     * Retorna o índice da última ocorrência do elemento, ou {@code -1} se não estiver presente.
     * Suporta {@code null}.
     */
    public int lastIndexOf(String element) {
        return 0;
    }

    /**
     * Retorna uma representação textual da lista no formato {@code [A, B, C]}.
     */
    @Override
    public String toString() {
        return "";
    }
}
