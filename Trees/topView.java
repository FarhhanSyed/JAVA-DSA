
import java.util.*;

public class topView {

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

    public static void top(Node root) {
        Queue<Group> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Group(root, 0));
        while (!q.isEmpty()) {
            Group g = q.remove();
            if (!map.containsKey(g.vertical)) {
                map.put(g.vertical, g.node.data);
            }
            if (g.node.left != null) {
                q.add(new Group(g.node.left, g.vertical - 1));
            }
            if (g.node.right != null) {
                q.add(new Group(g.node.right, g.vertical + 1));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int k : map.keySet()) {
            list.add(map.get(k));
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(90);
        root.right.right = new Node(100);
        top(root);
    }
}
