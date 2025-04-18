import java.util.*;

public class leastCommonAncestor {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lca(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main(String args[]) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.right = new Node(9);
        Node lca = lca(root, root.right.right, root.left.right);
        System.out.println("LCA : " + lca.data);
    }
}
