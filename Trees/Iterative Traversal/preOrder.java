
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

    public static void preOrder(Node root) {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node n = st.pop();
            list.add(n.data);
            if (n.right != null) {
                st.push(n.right);
            }
            if (n.left != null) {
                st.push(n.left);
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        preOrder(root);
    }
}
