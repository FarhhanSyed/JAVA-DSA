
public class minDistance {
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

    public static int height(Node root, Node p, int count) {
        if (root == null) {
            return -1;
        }
        if (root.data == p.data) {
            return count;
        }
        int left = height(root.left, p, count + 1);
        if (left != -1)
            return left;
        return height(root.right, p, count + 1);
    }

    public static int distance(Node root, Node p, Node q) {
        Node lca = lca(root, p, q);
        int heightP = height(lca, p, 0);
        int heightQ = height(lca, q, 0);
        return heightP + heightQ;
    }

    public static void main(String args[]) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.right = new Node(9);
        System.out.println(distance(root, root.left.left, root.right.right));
    }
}
