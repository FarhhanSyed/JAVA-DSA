
//TIme : O(V+2E)
//SPace : O(V)
import java.util.ArrayList;

public class cycleDFS {
    public static boolean detectCycle(ArrayList<ArrayList<Integer>> graph, boolean[] visit, int cur, int parent) {
        visit[cur] = true;
        for (int neigh : graph.get(cur)) {
            if (!visit[neigh]) {
                if (detectCycle(graph, visit, neigh, cur)) {
                    return true;
                }
            } else if (neigh != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = 8;
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(4);
        graph.get(3).add(5);
        graph.get(5).add(3);
        graph.get(6).add(7);
        graph.get(7).add(6);
        boolean visit[] = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visit[i]) {
                if (detectCycle(graph, visit, i, -1)) {
                    System.out.println("cycle detected");
                    break;
                }
            }
        }
    }
}
