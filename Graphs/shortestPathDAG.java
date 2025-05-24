
//shortest path in directed acyclic graph which uses topo sort
import java.util.*;

class Graph {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    int v;
    ArrayList<ArrayList<Edge>> graph;

    Graph(int v) {
        this.v = v;
        graph = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }

    void addEdge(int src, int dest, int wt) {
        graph.get(src).add(new Edge(src, dest, wt));
    }
}

class Pair {
    int src;
    int dest;
    int wt;

    Pair(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
}

public class shortestPathDAG {
    public static void topoSort(Graph g, Stack<Integer> st, boolean[] visit, int cur) {
        visit[cur] = true;
        for (Graph.Edge e : g.graph.get(cur)) {
            if (!visit[e.dest]) {
                topoSort(g, st, visit, e.dest);
            }
        }
        st.push(cur);
    }

    public static int[] shortestPath(Graph g) {
        int[] dist = new int[g.v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Stack<Integer> st = new Stack<>();
        boolean[] visit = new boolean[g.v];
        for (int i = 0; i < g.v; i++) {
            if (!visit[i]) {
                topoSort(g, st, visit, i);
            }
        }
        dist[st.peek()] = 0;
        while (!st.isEmpty()) {
            int u = st.pop();
            for (Graph.Edge e : g.graph.get(u)) {
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] + e.wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 6);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(5, 3, 1);
        int[] result = shortestPath(g);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
