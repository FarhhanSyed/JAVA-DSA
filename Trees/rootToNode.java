
import java.util.*;

public class rootToNode {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static boolean path(Node root, int x, ArrayList<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.data);
        if (root.data == x) {
            return true;
        }
        boolean left = path(root.left, x, list);
        boolean right = path(root.right, x, list);
        if (left || right) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.right = new Node(9);
        ArrayList<Integer> list = new ArrayList<>();
        path(root, 10, list);
        System.out.println(list);
    }
}
