public class Node<T> {
    private T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data){
        this(data, null, null);
    }
    public Node(T data, Node<T> left, Node<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData(){
        return this.data;
    }
    public void setData(T data){
        this.data = data;
    }
}