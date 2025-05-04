import java.util.*;

public class adjacencyMatrix {
    static class Graph {
        int v;
        int[][] graph;

        Graph(int vertices) {
            this.v = vertices;
            graph = new int[v][v];
        }

        void addEdge(int src, int dest) {
            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        void print() {
            System.out.println("Adjacency Matrix");
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(3, 1);
        g.print();
    }
}