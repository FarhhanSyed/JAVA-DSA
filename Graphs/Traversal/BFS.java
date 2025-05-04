
//Time : O(V+E)
//SPace : O(V)
import java.util.*;

public class BFS {
    static class Graph {

        static class Edge {
            int src;
            int dest;
            int weight;

            Edge(int s, int d, int w) {
                this.src = s;
                this.dest = d;
                this.weight = w;
            }
        }

        int V;
        ArrayList<Edge>[] graph;

        Graph(int vertices) {
            this.V = vertices;
            graph = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        void addEdge(int src, int dest, int weight) {
            graph[src].add(new Edge(src, dest, weight));
        }

        void print() {
            for (int i = 0; i < V; i++) {
                System.out.print("Node" + (i) + " : " + "[");
                for (Edge e : graph[i]) {
                    System.out.print("{" + e.src + "," + e.dest + "," + e.weight + "}");
                }
                System.out.println("]");
            }
        }
    }

    public static void createGraph(Graph g) {
        g.addEdge(0, 1, 1);
        g.addEdge(1, 0, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 0, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(3, 1, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(4, 2, 1);
        g.addEdge(3, 5, 1);
        g.addEdge(5, 3, 1);
        g.addEdge(3, 4, 1);
        g.addEdge(4, 3, 1);
        g.addEdge(4, 5, 1);
        g.addEdge(5, 4, 1);
        g.addEdge(5, 6, 1);
        g.addEdge(6, 5, 1);
    }

    public static void bfs(Graph g) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[g.V];
        q.add(0);
        while (!q.isEmpty()) {
            int vertex = q.remove();
            if (!visited[vertex]) {
                System.out.print(vertex + " ");
                visited[vertex] = true;
                for (Graph.Edge edge : g.graph[vertex]) {
                    q.add(edge.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        createGraph(g);
        // g.print();
        bfs(g);
    }
}
