import java.util.Scanner;

public class GraphBSTApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BSTVisualizer<Integer> bst = new BSTVisualizer<>();
        
        while (true) {
            System.out.println("\n=== VISUALIZADOR DE ARBOL BINARIO DE BUSQUEDA ===");
            System.out.println("1. Insertar desde palabra");
            System.out.println("2. Insertar numeros manualmente");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Eliminar elemento");
            System.out.println("5. Mostrar informacion del árbol");
            System.out.println("6. Mostrar visualizacion");
            System.out.println("7. Limpiar arbol");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese una palabra: ");
                    String palabra = scanner.nextLine();
                    for (char c : palabra.toCharArray()) {
                        bst.insert((int) c);
                        System.out.println("Insertado: '" + c + "' (ASCII: " + (int)c + ")");
                    }
                    break;
                    
                case 2:
                    System.out.print("Ingrese numeros separados por espacios: ");
                    String[] numeros = scanner.nextLine().split(" ");
                    for (String num : numeros) {
                        try {
                            int valor = Integer.parseInt(num.trim());
                            bst.insert(valor);
                            System.out.println("Insertado: " + valor);
                        } catch (NumberFormatException e) {
                            System.out.println("'" + num + "' no es un numero válido");
                        }
                    }
                    break;
                    
                case 3:
                    System.out.print("Ingrese elemento a buscar: ");
                    int buscar = scanner.nextInt();
                    boolean encontrado = bst.search(buscar);
                    System.out.println("Elemento " + buscar + 
                        (encontrado ? " Si esta en el arbol" : " NO esta en el arbol"));
                    break;
                    
                case 4:
                    if (bst.isEmpty()) {
                        System.out.println("El arbol está vacío");
                        break;
                    }
                    System.out.print("Ingrese elemento a eliminar: ");
                    int eliminar = scanner.nextInt();
                    if (bst.search(eliminar)) {
                        bst.remove(eliminar);
                        System.out.println("Elemento " + eliminar + " eliminado");
                    } else {
                        System.out.println("El elemento " + eliminar + " no existe en el árbol");
                    }
                    break;
                    
                case 5:
                    if (bst.isEmpty()) {
                        System.out.println("El árbol está vacío");
                    } else {
                        bst.showTreeInfo();
                    }
                    break;
                    
                case 6:
                    if (bst.isEmpty()) {
                        System.out.println("El árbol está vacío. Inserte elementos primero.");
                    } else {
                        System.out.println("Mostrando visualización del árbol...");
                        bst.displayTree();
                    }
                    break;
                    
                case 7:
                    bst.destroy();
                    System.out.println("Árbol limpiado");
                    break;
                    
                case 0:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}