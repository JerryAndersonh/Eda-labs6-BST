import java.util.Scanner;

public class AsciiBSTApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BSTInterface<Integer> bst = new BinarySearchTree<>();

        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.nextLine();

        System.out.println("\nInsertando letras como valores ASCII:");
        for (char c : palabra.toCharArray()) {
            int ascii = (int) c;
            System.out.println("'" + c + "' → " + ascii);
            bst.insert(ascii);
        }

        System.out.println("\nRecorrido InOrder (ordenado):");
        bst.inOrder();

        System.out.println("Recorrido PreOrder:");
        bst.preOrder();

        System.out.println("Recorrido PostOrder:");
        bst.postOrder();

        System.out.println("\nValor mínimo (carácter con menor ASCII): " + bst.min());
        System.out.println("Valor máximo (carácter con mayor ASCII): " + bst.max());
    }
}
