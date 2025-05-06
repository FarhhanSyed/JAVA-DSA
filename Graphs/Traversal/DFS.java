//Time : O(V+E)
//Space : O(V)

import java.util.*;

public class DFS {
    static class Graph {
        static class Edge {
            int src;
            int dest;

            Edge(int s, int d) {
                this.src = s;
                this.dest = d;
            }
        }

        int v;
        ArrayList<Edge>[] graph;

        Graph(int v) {
            this.v = v;
            graph = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        void addEdge(int source, int destina) {
            graph[source].add(new Edge(source, destina));
        }
    }

    public static void createGraph(Graph g) {
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(3, 1);
        g.addEdge(2, 4);
        g.addEdge(4, 2);
        g.addEdge(3, 5);
        g.addEdge(5, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 5);
    }

    public static void dfs(Graph g, int cur, boolean[] visit) {
        visit[cur] = true;
        System.out.print(cur + " ");
        for (Graph.Edge e : g.graph[cur]) {
            if (!visit[e.dest]) {
                dfs(g, e.dest, visit);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        createGraph(g);
        boolean[] visit = new boolean[g.v];
        dfs(g, 0, visit);
    }
}
