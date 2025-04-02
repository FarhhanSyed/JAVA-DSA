import java.util.*;

public class all {
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

    static class Pair {
        Node node;
        int num;

        Pair(Node root, int n) {
            this.node = root;
            this.num = n;
        }
    }

    public static void allTraversals(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while (!st.isEmpty()) {
            Pair p = st.peek();
            if (p.num == 1) {
                preorder.add(p.node.data);
                p.num++;
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 1));
                }
            } else if (p.num == 2) {
                inorder.add(p.node.data);
                p.num++;
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 1));
                }
            } else {
                postorder.add(p.node.data);
                st.pop();
            }
        }
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        allTraversals(root);
    }
}
