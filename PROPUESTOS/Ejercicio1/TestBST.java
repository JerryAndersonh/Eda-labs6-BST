public class TestBST {
    public static void main(String[] args) {
        BSTInterface<Integer> bst = new BinarySearchTree<>();

        System.out.println("Insertando valores...");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("InOrder:");
        bst.inOrder(); // 20 30 40 50 60 70 80

        System.out.println("PreOrder:");
        bst.preOrder();

        System.out.println("PostOrder:");
        bst.postOrder();

        System.out.println("Buscar 40: " + bst.search(40)); // true
        System.out.println("Buscar 100: " + bst.search(100)); // false

        System.out.println("Mínimo: " + bst.min());
        System.out.println("Máximo: " + bst.max());

        System.out.println("Predecesor de 60: " + bst.predecessor(60)); // 50
        System.out.println("Sucesor de 60: " + bst.successor(60));     // 70

        System.out.println("Eliminando 30...");
        bst.remove(30);

        System.out.println("InOrder después de eliminar:");
        bst.inOrder();

        System.out.println("¿Está vacío?: " + bst.isEmpty());
        System.out.println("Destruyendo árbol...");
        bst.destroy();
        System.out.println("¿Está vacío?: " + bst.isEmpty());
    }
}
