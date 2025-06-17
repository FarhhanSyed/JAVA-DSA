import java.util.HashSet;

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

public class stoneRemoval {
    public static int removeStones(int[][] stones) {
        if (stones.length == 1) {
            return 0;
        }
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSetUnion dsu = new DisjointSetUnion(maxRow + maxCol + 2);
        HashSet<Integer> stoneNodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int r = stones[i][0];
            int c = stones[i][1] + maxRow + 1;
            dsu.union(r, c);
            stoneNodes.add(r);
            stoneNodes.add(c);
        }
        int cnt = 0;
        for (int k : stoneNodes) {
            if (dsu.findP(k) == k) {
                cnt++;
            }
        }
        return n - cnt;
    }

    public static void main(String[] args) {
        int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println(removeStones(stones));
    }
}
