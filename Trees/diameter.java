
public class diameter {

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

    public static int findMax(Node root, int[] max) {
        if (root == null) {
            return 0;
        }
        int lh = findMax(root.left, max);
        int rh = findMax(root.right, max);
        max[0] = Math.max(max[0], (lh + rh));
        return Math.max(lh, rh) + 1;
    }

    public static int diameterOfBinaryTree(Node root) {
        int[] max = new int[1];
        findMax(root, max);
        return max[0];
    }

    public static void main(String args[]) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.right = new Node(9);
        System.out.println(diameterOfBinaryTree(root));
    }
}
