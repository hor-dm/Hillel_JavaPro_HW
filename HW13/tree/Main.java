package tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.addNode(4);
        tree.addNode(15);
        tree.addNode(31);
        tree.addNode(12);
        tree.addNode(1);
        tree.addNode(5);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(6);
        tree.addNode(8);
        tree.addNode(10);

        tree.printTree();

    }
}
