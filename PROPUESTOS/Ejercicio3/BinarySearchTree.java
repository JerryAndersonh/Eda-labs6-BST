public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T> {
    protected static class Node<T> {
        T data;
        Node<T> left, right;

        public Node(T data) {
            this.data = data;
            left = right = null;
        }
    }

    protected Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void destroy() {
        root = null;
    }

    public void insert(T data) {
        root = insertRec(root, data);
    }

    public Node<T> getRoot() {
        return root;
    }

    private Node<T> insertRec(Node<T> node, T data) {
        if (node == null) return new Node<>(data);
        if (data.compareTo(node.data) < 0)
            node.left = insertRec(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = insertRec(node.right, data);
        return node;
    }

    public void remove(T data) {
        root = removeRec(root, data);
    }

    private Node<T> removeRec(Node<T> node, T data) {
        if (node == null) return null;

        if (data.compareTo(node.data) < 0)
            node.left = removeRec(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = removeRec(node.right, data);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node<T> min = findMin(node.right);
            node.data = min.data;
            node.right = removeRec(node.right, min.data);
        }
        return node;
    }

    public boolean search(T data) {
        return searchRec(root, data) != null;
    }

    private Node<T> searchRec(Node<T> node, T data) {
        if (node == null || node.data.equals(data)) return node;
        if (data.compareTo(node.data) < 0)
            return searchRec(node.left, data);
        return searchRec(node.right, data);
    }

    public T min() {
        if (root == null) return null;
        return findMin(root).data;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public T max() {
        if (root == null) return null;
        Node<T> current = root;
        while (current.right != null) current = current.right;
        return current.data;
    }

    public T predecessor(T data) {
        Node<T> current = root;
        Node<T> pred = null;

        while (current != null) {
            if (data.compareTo(current.data) > 0) {
                pred = current;
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return pred != null ? pred.data : null;
    }

    public T successor(T data) {
        Node<T> current = root;
        Node<T> succ = null;

        while (current != null) {
            if (data.compareTo(current.data) < 0) {
                succ = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return succ != null ? succ.data : null;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<T> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node<T> node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.data + " ");
        }
    }
}