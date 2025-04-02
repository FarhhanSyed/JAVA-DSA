import java.util.*;

public class preOrder {
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

    public static void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.right = new Node(9);
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);
        System.out.println(list);
    }
}
