public class BTS<T extends Comparable<T>>{
    private Node<T> root;
    
    public BTS(){
        this.root = null;
    }

    public void insert(T value){
        root = insertRec(root, value);
    }
    private Node<T> insertRec(Node<T> current, T value){
        if(current == null){
            return new Node<>(value);
        }
        if(value.compareTo(current.getData()) < 0){
            current.left = insertRec(current.left, value);
        } else if(value.compareTo(current.getData())>0) {
            current.right = insertRec(current.right, value);
        }
        return current;
    }

    public boolean search(T value){
        return searchRec(root, value);
    }
    private boolean searchRec(Node<T> current, T value){
        if(current == null){
            return false;
        }
        int cmp = value.compareTo(current.getData());
        if(cmp == 0)
            return true;
        else if (cmp < 0)
            return searchRec(current.left, value);
        else 
            return searchRec(current.right, value);
    }

    public void inorder(){
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(Node<T> current){
        if(current != null){
            inorderRec(current.left);
            System.out.print(current.getData() + " ");
            inorderRec(current.right);
        }
    }
}