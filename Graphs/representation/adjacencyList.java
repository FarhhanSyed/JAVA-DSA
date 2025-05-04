 /*
                        (5)
                    0 ------ 1 
                            / \
                       (2) /   \  (3)
                          /     \
                         2 ------ 3    
                         |   (1)
                   (2)   |
                         |
                         4
         
*/
//Space : O(V+E)
import java.util.*;
         
public class adjacencyList {
    static class Graph {
         
        static class Edge {
            int src;
            int dest;
            int weight;
         
            Edge(int s, int d,int w) {
                this.src = s;
                this.dest = d;
                this.weight=w;
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
         
        void addEdge(int src, int dest,int weight) {
            graph[src].add(new Edge(src, dest, weight));
        }
         
        void print() {
            for (int i = 0; i < V; i++) {
                System.out.print("Node" + (i) + " : " + "[");
                for (Edge e : graph[i]) {
                        System.out.print("{" + e.src + "," + e.dest+","+e.weight);
                }
                System.out.println("]");
            }
        }
    }
         
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 5);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 4, 2);
        g.addEdge(2, 1, 2);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 3);
        g.addEdge(3, 2, 1);
        g.addEdge(4, 2, 2);
        g.print();
        }
}
         