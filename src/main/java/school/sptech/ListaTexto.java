package school.sptech;

import java.util.Arrays;
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
        if (numElements >= elements.length) {
            resize();
        }
        elements[numElements] = element;
        numElements++;
        return true;
    }

    /**
     * Insere o elemento na posição indicada.
     * Os elementos a partir dessa posição permanecem em ordem após o novo.
     * Índice válido: {@code 0 <= index <= size()}.
     *
     * @throws IndexOutOfBoundsException se {@code index < 0 || index > size()}
     */
    public void add(int index, String element) {
        if (index < 0 || index > numElements) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numElements);
        }
        if (numElements >= elements.length) {
            resize();
        }
        for (int i = numElements; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        numElements++;
    }

    /**
     * Insere todos os elementos de {@code other} ao final desta lista, em ordem.
     *
     * @return {@code true} se ao menos um elemento foi inserido; {@code false} se {@code other} estiver vazia
     */
    public boolean addAll(ListaTexto other) {
        if (other.numElements == 0) {
            return false;
        }
        for (int i = 0; i < other.numElements; i++) {
            add(other.elements[i]);
        }
        return true;
    }

    /**
     * Substitui o elemento na posição indicada pelo novo valor.
     * Índice válido: {@code 0 <= index < size()}.
     *
     * @return o valor que ocupava a posição antes da substituição
     * @throws IndexOutOfBoundsException se {@code index < 0 || index >= size()}
     */
    public String set(int index, String element) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numElements);
        }
        String old = elements[index];
        elements[index] = element;
        return old;
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
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numElements);
        }
        return elements[index];
    }

    /**
     * Retorna a quantidade de elementos na lista.
     */
    public int size() {
        return numElements;
    }

    /**
     * Retorna {@code true} se a lista não contiver elementos.
     */
    public boolean isEmpty() {
        return numElements == 0;
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
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numElements);
        }
        String removed = elements[index];
        for (int i = index; i < numElements - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[numElements - 1] = null;
        numElements--;
        return removed;
    }

    /**
     * Remove a primeira ocorrência do elemento informado. Suporta {@code null}.
     *
     * @return {@code true} se o elemento foi encontrado e removido; {@code false} caso contrário
     */
    public boolean remove(String element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * Remove todos os elementos da lista. A capacidade interna não é alterada.
     */
    public void clear() {
        for (int i = 0; i < numElements; i++) {
            elements[i] = null;
        }
        numElements = 0;
    }

    // -------------------------------
    // CONSULTA
    // -------------------------------

    /**
     * Retorna {@code true} se o elemento informado estiver presente na lista. Suporta {@code null}.
     */
    public boolean contains(String element) {
        return indexOf(element) != -1;
    }

    /**
     * Retorna o índice da primeira ocorrência do elemento, ou {@code -1} se não estiver presente.
     * Suporta {@code null}.
     */
    public int indexOf(String element) {
        for (int i = 0; i < numElements; i++) {
            if (Objects.equals(element, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retorna o índice da última ocorrência do elemento, ou {@code -1} se não estiver presente.
     * Suporta {@code null}.
     */
    public int lastIndexOf(String element) {
        for (int i = numElements - 1; i >= 0; i--) {
            if (Objects.equals(element, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retorna uma representação textual da lista no formato {@code [A, B, C]}.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numElements; i++) {
            if (i > 0) sb.append(", ");
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
}
