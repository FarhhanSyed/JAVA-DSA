
//BFS
//Time : O(V+E)
//Space : O(V)
import java.util.*;

public class Kahns {
    public static void kahnSort(ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            for (int neigh : graph.get(i)) {
                indegree[neigh]++;
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.remove();
            System.out.print(cur + " ");
            for (int neigh : graph.get(cur)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = 6;
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        kahnSort(graph);
    }
}