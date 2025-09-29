package school.sptech;

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
     * Adiciona um elemento no final da lista.
     * Se o array estiver cheio, deve dobrar de tamanho (resize).
     * Retorna true se conseguiu inserir.
     */
    public boolean add(String element) {
        return true;
    }

    /**
     * Adiciona um elemento em uma posição específica da lista.
     * Deve "empurrar" os elementos seguintes uma posição à frente.
     * Se index for inválido, deve lançar exceção.
     */
    public boolean add(int index, String element) {
        return false;
    }

    /**
     * Adiciona todos os elementos de um array na lista atual.
     * Pode chamar add(String) para cada item.
     * Retorna true se pelo menos um elemento foi adicionado.
     */
    public boolean addAll(ListaTexto other) {
        return false;
    }

    /**
     * Substitui o valor da posição indicada por outro.
     * Retorna o valor antigo que estava nessa posição.
     * Se index for inválido, deve lançar exceção.
     */
    public String set(int index, String element) {
        return null;
    }

    // -------------------------------
    // ACESSO
    // -------------------------------

    /**
     * Retorna o elemento na posição indicada.
     * Se index for inválido, deve lançar exceção.
     */
    public String get(int index) {
        return null;
    }

    /**
     * Retorna a quantidade de elementos armazenados (não a capacidade do array).
     */
    public int size() {
        return 0;
    }

    /**
     * Retorna true se a lista estiver vazia (size == 0).
     */
    public boolean isEmpty() {
        return false;
    }

    // -------------------------------
    // REMOÇÃO
    // -------------------------------

    /**
     * Remove o elemento na posição indicada.
     * Deve "puxar" os elementos seguintes para trás.
     * Retorna o valor removido.
     */
    public String remove(int index) {
        return null;
    }

    /**
     * Remove a primeira ocorrência do elemento informado.
     * Retorna true se encontrou e removeu.
     */
    public boolean remove(String element) {
        return false;
    }

    /**
     * Remove todos os elementos da lista (zerar numElements).
     * Mantém a capacidade do array.
     */
    public void clear() {

    }

    // -------------------------------
    // CONSULTA
    // -------------------------------

    /**
     * Retorna true se a lista contiver o elemento informado.
     */
    public boolean contains(String element) {
        return false;
    }

    /**
     * Retorna a posição da primeira ocorrência do elemento.
     * Se não existir, retorna -1.
     */
    public int indexOf(String element) {
        return 0;
    }

    /**
     * Retorna a posição da última ocorrência do elemento.
     * Se não existir, retorna -1.
     */
    public int lastIndexOf(String element) {
        return 0;
    }
}