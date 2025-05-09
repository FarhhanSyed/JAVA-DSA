import java.util.*;

public class cycleBFS {
    static class Pair {
        int cur;
        int parent;

        Pair(int c, int p) {
            this.cur = c;
            this.parent = p;
        }
    }

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> graph, boolean[] visit, int cur) {
        visit[cur] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(cur, -1));
        while (!q.isEmpty()) {
            int node = q.peek().cur;
            int parent = q.peek().parent;
            q.remove();
            for (int neigh : graph.get(node)) {
                if (!visit[neigh]) {
                    visit[neigh] = true;
                    q.add(new Pair(neigh, node));
                } else if (neigh != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = 8;
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(4);
        graph.get(3).add(5);
        graph.get(5).add(3);
        graph.get(6).add(7);
        graph.get(7).add(6);
        boolean visit[] = new boolean[graph.size()];
        for (int i = 0; i < v; i++) {
            if (!visit[i]) {
                if (detectCycle(graph, visit, i)) {
                    System.out.println("Cycle detected");
                    break;
                }
            }
        }
    }
}
