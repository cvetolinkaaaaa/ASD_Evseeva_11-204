public class TreeRealisation {
    public static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    public static class Tree{
        Node root;
        public Tree(){
            this.root = null;
        }
        public Tree(int value) {
            Node node = new Node(value);
            this.root = node;
        }
        private Node add (Node root, int value) {
            if (root == null) {
                Node newNode = new Node(value);
                return newNode;
            }
            if (root.value > value) {
                root.leftChild = add(root.leftChild, value);
            }
            if (root.value < value) {
                root.rightChild = add(root.rightChild, value);
            }
            return root;
        }
        public boolean get(int value) {
            return contains(root, value);
        }
        private boolean contains(Node node, int value) {
            if (node == null) {
                return false;
            }
            if (node.value == value) {
                return true;
            } else if (value > node.value) {
                return contains(node.leftChild, value);
            } else if (value < node.value) {
                return contains(node.rightChild, value);
            }
            return false;
        }

    }

}