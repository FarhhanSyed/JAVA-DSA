
//Cycle detection in Directed acyclic graph(DAG)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class detectCycle {
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
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.remove();
            cnt++;
            for (int neigh : graph.get(cur)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }
        if (cnt != graph.size()) {
            System.out.println("cycle Detected");
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = 6;
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(2).add(4);
        kahnSort(graph);
    }
}