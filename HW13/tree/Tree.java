package tree;

public class Tree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void addNode(int value) {
        root = addNode(root, value);
    }

    private Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);

        }
        if (value < current.getValue()) {
            current.setLeft(addNode(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(addNode(current.getRight(), value));
        } else {
            return current;
        }
        return current;
    }

    public void printTree(){
        Node node = this.getRoot();
        printNodeRecurs(node);
    }

    private void printNodeRecurs(Node current) {
        if (current != null) {
            printNodeRecurs(current.getLeft());
            System.out.print(current.getValue() + " ");
            printNodeRecurs(current.getRight());
        }
    }

}
