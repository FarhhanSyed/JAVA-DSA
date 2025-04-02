import java.util.*;

public class levelOrder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void level(Node root, Queue<Node> q) {
        if (q.isEmpty()) {
            return;
        }
        Node n = q.remove();
        System.out.print(n.data + " ");
        if (n.left != null) {
            q.add(n.left);
        }
        if (n.right != null) {
            q.add(n.right);
        }
        level(q.peek(), q);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.right = new Node(9);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        level(root, q);
    }
}