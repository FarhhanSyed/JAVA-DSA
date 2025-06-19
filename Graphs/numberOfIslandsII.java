import java.util.*;

class DisjointSetUnion {
    int[] rank, parent;

    DisjointSetUnion(int v) {
        rank = new int[v + 1];
        parent = new int[v + 1];
        for (int i = 0; i < v; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int findP(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = findP(parent[u]);
    }

    public void union(int u, int v) {
        int pu = findP(u);
        int pv = findP(v);
        if (pu == pv)
            return;
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

public class numberOfIslandsII {
    public static ArrayList<Integer> numofIslands(int[][] operators, int n, int m) {
        DisjointSetUnion dsu = new DisjointSetUnion(n * m);
        boolean[][] visited = new boolean[n][m];
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = 0;
        for (int[] op : operators) {
            int row = op[0];
            int col = op[1];
            int cell = row * m + col;
            if (visited[row][col]) {
                ans.add(cnt);
                continue;
            }
            visited[row][col] = true;
            cnt++;
            int[] drow = { 1, -1, 0, 0 };
            int[] dcol = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int nr = row + drow[i];
                int nc = col + dcol[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && visited[nr][nc]) {
                    int adjCell = nr * m + nc;
                    if (dsu.findP(adjCell) != dsu.findP(cell)) {
                        cnt--;
                        dsu.union(adjCell, cell);
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int k = 4;
        int[][] A = { { 1, 1 }, { 0, 1 }, { 3, 3 }, { 3, 4 } };
        System.out.println(numofIslands(A, n, m));
    }
}
