
import java.util.*;

public class bottomView {

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

    static class Group {

        int vertical;
        Node node;

        Group(Node node, int v) {
            this.vertical = v;
            this.node = node;
        }
    }

    public static void bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Group> q = new LinkedList<>();
        q.add(new Group(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!q.isEmpty()) {
            Group g = q.remove();
            map.put(g.vertical, g.node.data);
            if (g.node.left != null) {
                q.add(new Group(g.node.left, g.vertical - 1));
            }
            if (g.node.right != null) {
                q.add(new Group(g.node.right, g.vertical + 1));
            }
        }
        for (int k : map.keySet()) {
            list.add(map.get(k));
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.right = new Node(22);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.right.left.right = new Node(14);
        bottomView(root);
    }
}
