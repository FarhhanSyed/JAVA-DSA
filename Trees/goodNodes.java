
public class goodNodes {

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

    public static int helper(Node root, int max) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.data >= max) {
            count++;
            max = root.data;
        }
        count += helper(root.left, max);
        count += helper(root.right, max);
        return count;
    }

    public static int good(Node root) {
        return helper(root, root.data);
    }

    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.right = new Node(1);
        root.right.left = new Node(15);
        System.out.println(good(root));
    }
}
