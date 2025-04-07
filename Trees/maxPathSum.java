//Time-Complecity : O(n)
//Space-Complecity : O(n)

public class maxPathSum {

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

    public static int findMax(Node root, int max[]) {
        if (root == null) {
            return 0;
        }
        int lsum = Math.max(0, findMax(root.left, max));
        int rsum = Math.max(0, findMax(root.right, max));
        max[0] = Math.max(max[0], (root.data + lsum + rsum));
        return root.data + Math.max(lsum, rsum);
    }

    public static int pathSum(Node root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMax(root, max);
        return max[0];
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.err.println(pathSum(root));
    }
}
