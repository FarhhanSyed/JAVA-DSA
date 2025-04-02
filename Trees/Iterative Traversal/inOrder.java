
import java.util.*;

public class inOrder {
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

    public static void inorder(Node root) {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node cur = root;
        boolean flag = false;
        while (!flag) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                if (st.isEmpty()) {
                    flag = true;
                } else {
                    cur = st.pop();
                    list.add(cur.data);
                    cur = cur.right;
                }
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
        inorder(root);
    }
}
