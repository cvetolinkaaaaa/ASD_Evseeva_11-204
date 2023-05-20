import java.util.LinkedList;
import java.util.Queue;

public class TreeRealisation {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right= null;
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
                root.left = add(root.left, value);
            }
            if (root.value < value) {
                root.right = add(root.right, value);
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
                return contains(node.left, value);
            } else if (value < node.value) {
                return contains(node.right, value);
            }
            return false;
        }
        void BFS() {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node tempNode = queue.poll();
                System.out.print(tempNode.value + " ");
                if (tempNode.left != null)
                    queue.add(tempNode.left);
                if (tempNode.right != null)
                    queue.add(tempNode.right);
            }
        }


    }

}