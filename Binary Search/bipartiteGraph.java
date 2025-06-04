import java.util.*;

public class bipartiteGraph {
    public static boolean checkBipartite(ArrayList<ArrayList<Integer>> graph, int[] color, int col, int idx) {
        color[idx] = col;
        for (int neigh : graph.get(idx)) {
            if (color[neigh] == -1) {
                if (!checkBipartite(graph, color, 1 - col, neigh)) {
                    return false;
                }
            } else if (color[neigh] == col) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int neigh : graph[i]) {
                list.get(i).add(neigh);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color, -1);
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!checkBipartite(list, color, 0, i)) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println(" Not a Bipartite Graph");
        } else {
            System.out.println("Bipartite Graph");
        }
    }
}
