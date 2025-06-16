public class Main{
    public static void main(String[] args){
        BTS<Integer> bst = new BTS<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(10);
        bst.insert(40);
        bst.insert(60);
        System.out.println("Inorder: ");
        bst.inorder();

        System.out.println("Contiene 50? "+ bst.search(20));
        System.out.println("Contiene 60? "+ bst.search(60));
    }
}