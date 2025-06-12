
//Time-Complexity:O(V*E)
//SPace-Complexity:O(V)
import java.util.*;

public class bellmanFord {
    public static int[] bellman(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int) (1e8);
        }
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int[] ed : edges) {
                int u = ed[0];
                int v = ed[1];
                int wt = ed[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for (int[] ed : edges) {
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int[] tmp = new int[1];
                tmp[0] = -1;
                return tmp;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { { 1, 3, 2 }, { 4, 3, -1 }, { 2, 4, 1 }, { 1, 2, 1 }, { 0, 1, 5 } };
        int src = 0;
        int[] res = bellman(V, edges, src);
        System.out.println(Arrays.toString(res));
    }
}
