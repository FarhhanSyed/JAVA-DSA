import java.util.*;

public class shortestPathUndirected {
    public static int[] shortestPath(ArrayList<ArrayList<Integer>> graph, int v) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(0);
        dist[0] = 0;
        while (!q.isEmpty()) {
            int n = q.remove();
            for (int neigh : graph.get(n)) {
                if (dist[n] + 1 < dist[neigh]) {
                    dist[neigh] = 1 + dist[n];
                    q.add(neigh);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int v = 9;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(3);
        graph.get(3).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(4);
        graph.get(5).add(6);
        graph.get(6).add(5);
        graph.get(2).add(6);
        graph.get(6).add(2);
        graph.get(6).add(7);
        graph.get(7).add(6);
        graph.get(6).add(8);
        graph.get(8).add(6);
        graph.get(7).add(8);
        graph.get(8).add(7);
        int[] res = new int[v];
        res = shortestPath(graph, v);
        System.out.println(Arrays.toString(res));
    }
}