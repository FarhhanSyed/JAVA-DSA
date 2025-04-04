

public class sumOfNodes {

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

    public static int func(Node root, int sum) {
        if (root == null) {
            return 0;
        }

        int left = func(root.left, sum);

        int right = func(root.right, sum);

        sum += (left + right) + root.data;
        return sum;
    }

    public static void main(String args[]) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.right = new Node(9);
        System.out.println(func(root, 0));
    }
}
