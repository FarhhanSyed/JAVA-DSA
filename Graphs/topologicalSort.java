
//Time : O(V+E)
//Space : O(V)
//Topological Sort is a linear ordering of vertices in a Directed Acyclic Graph (DAG)
//such that for every directed edge u → v, vertex u comes before v in the ordering.
import java.util.*;

public class topologicalSort {
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visit, int cur, Stack<Integer> st) {
        visit[cur] = true;
        for (int neigh : graph.get(cur)) {
            if (!visit[neigh]) {
                dfs(graph, visit, neigh, st);
            }
        }
        st.push(cur);
    }

    public static void topoSort(ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> st = new Stack<>();
        boolean visit[] = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visit[i]) {
                dfs(graph, visit, i, st);
            }
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
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
        topoSort(graph);
    }
}
