import java.util.*;

class Pair1 {
    int wt;
    int node;

    Pair1(int w, int n) {
        this.wt = w;
        this.node = n;
    }
}

public class primsAlgorithm {
    public static int minSpanTree(ArrayList<ArrayList<Pair1>> graph, int n) {
        boolean[] visit = new boolean[n];
        PriorityQueue<Pair1> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        pq.add(new Pair1(0, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            int weigh = pq.peek().wt;
            int node = pq.peek().node;
            pq.remove();
            if (visit[node])
                continue;
            visit[node] = true;
            sum += weigh;
            for (Pair1 p : graph.get(node)) {
                if (!visit[p.node]) {
                    pq.add(new Pair1(p.wt, p.node));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Pair1>> graph = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair1(2, 1));
        graph.get(1).add(new Pair1(2, 0));
        graph.get(0).add(new Pair1(6, 3));
        graph.get(3).add(new Pair1(6, 0));
        graph.get(3).add(new Pair1(8, 1));
        graph.get(1).add(new Pair1(8, 3));
        graph.get(1).add(new Pair1(5, 4));
        graph.get(4).add(new Pair1(5, 1));
        graph.get(1).add(new Pair1(3, 2));
        graph.get(2).add(new Pair1(3, 1));
        graph.get(4).add(new Pair1(7, 2));
        graph.get(2).add(new Pair1(7, 4));
        System.out.println(minSpanTree(graph, n));
    }
}
