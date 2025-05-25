
//Djisktra's-algo to find the shortest path from a source node to all the other nodes in the graph
//Time Complexity :  O((V+E)*log V)
import java.util.*;

class Pairr {
    int dest;
    int wt;

    Pairr(int d, int w) {
        this.dest = d;
        this.wt = w;
    }
}

public class Djisktras {
    public static int[] shortestPath(ArrayList<ArrayList<Pairr>> graph) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pairr> pq = new PriorityQueue<Pairr>((x, y) -> x.wt - y.wt);
        dist[0] = 0;
        pq.add(new Pairr(0, 0));
        while (!pq.isEmpty()) {
            Pairr p = pq.remove();
            int distance = p.wt;
            int node = p.dest;
            for (Pairr pair : graph.get(node)) {
                int adjNode = pair.dest;
                int edgeWeight = pair.wt;
                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pairr(adjNode, dist[adjNode]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Pairr>> graph = new ArrayList<>();
        int v = 6;
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pairr(1, 4));
        graph.get(1).add(new Pairr(0, 4));
        graph.get(0).add(new Pairr(2, 4));
        graph.get(2).add(new Pairr(0, 4));
        graph.get(1).add(new Pairr(2, 2));
        graph.get(2).add(new Pairr(1, 2));
        graph.get(2).add(new Pairr(3, 3));
        graph.get(3).add(new Pairr(2, 3));
        graph.get(2).add(new Pairr(4, 1));
        graph.get(4).add(new Pairr(2, 1));
        graph.get(2).add(new Pairr(5, 6));
        graph.get(5).add(new Pairr(2, 6));
        graph.get(3).add(new Pairr(5, 2));
        graph.get(5).add(new Pairr(3, 2));
        graph.get(4).add(new Pairr(5, 3));
        graph.get(5).add(new Pairr(4, 3));
        int[] res = new int[graph.size()];
        res = shortestPath(graph);
        System.out.println(Arrays.toString(res));
    }
}
