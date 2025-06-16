public interface BSTInterface<T extends Comparable<T>> {
    void insert(T data);
    void remove(T data);
    boolean search(T data);
    T min();
    T max();
    T predecessor(T data);
    T successor(T data);
    void inOrder();
    void preOrder();
    void postOrder();
    boolean isEmpty();
    void destroy();
}