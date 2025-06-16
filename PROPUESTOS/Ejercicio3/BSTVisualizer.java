import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class BSTVisualizer<T extends Comparable<T>> extends BinarySearchTree<T> {
    private Graph graph;
    private int nodeCounter = 0;
    
    public void displayTree() {
        System.setProperty("org.graphstream.ui", "swing");
        graph = new SingleGraph("Árbol Binario de Búsqueda");
        
        graph.setAttribute("ui.stylesheet", 
            "node {" +
            "   fill-color: #3498DB;" +
            "   stroke-mode: plain;" +
            "   stroke-color: #2C3E50;" +
            "   stroke-width: 2px;" +
            "   size: 40px;" +
            "   text-size: 18px;" +
            "   text-alignment: center;" +
            "   text-color: white;" +
            "   text-style: bold;" +
            "   shape: circle;" +
            "}" +
            "node.root {" +
            "   fill-color: #E74C3C;" +
            "}" +
            "node.leaf {" +
            "   fill-color: #2ECC71;" +
            "}" +
            "edge {" +
            "   fill-color: #2C3E50;" +
            "   size: 3px;" +
            "   arrow-shape: none;" +
            "}" +
            "graph {" +
            "   fill-color: white;" +
            "   padding: 50px;" +
            "}"
        );
        
        graph.setAutoCreate(true);
        graph.setStrict(false);
        nodeCounter = 0;
        
        if (super.getRoot() != null) {
            buildGraph(super.getRoot(), null, 0, 0.0, 1000.0);
            graph.display().getDefaultView().getCamera().setAutoFitView(true);
        } else {
            System.out.println("El árbol está vacío.");
        }
    }
    
    private void buildGraph(Node<T> node, String parentId, int depth, double x, double range) {
        if (node == null) return;
        
        String nodeId = "node_" + nodeCounter++;
        org.graphstream.graph.Node graphNode = graph.addNode(nodeId);
        graphNode.setAttribute("ui.label", node.data.toString());
        
        double y = -depth * 100;
        graphNode.setAttribute("xyz", x, y, 0);
        
        // Marcar nodo raíz
        if (depth == 0) {
            graphNode.setAttribute("ui.class", "root");
        }
        
        // Marcar nodos hoja
        if (node.left == null && node.right == null) {
            graphNode.setAttribute("ui.class", "leaf");
        }
        
        if (parentId != null) {
            String edgeId = parentId + "_to_" + nodeId;
            graph.addEdge(edgeId, parentId, nodeId, true);
        }
        
        double newRange = range / 2;
        
        if (node.left != null) {
            double leftX = x - newRange;
            buildGraph(node.left, nodeId, depth + 1, leftX, newRange);
        }
        if (node.right != null) {
            double rightX = x + newRange;
            buildGraph(node.right, nodeId, depth + 1, rightX, newRange);
        }
    }
    
    public void showTreeInfo() {
        System.out.println("\n=== Información del Árbol ===");
        System.out.println("Raíz: " + (getRoot() != null ? getRoot().data : "null"));
        System.out.println("Vacío: " + isEmpty());
        if (!isEmpty()) {
            System.out.println("Mínimo: " + min());
            System.out.println("Máximo: " + max());
        }
        
        System.out.print("Recorrido en orden: ");
        inOrder();
        
        System.out.print("Recorrido pre-orden: ");
        preOrder();
        
        System.out.print("Recorrido post-orden: ");
        postOrder();
    }
}