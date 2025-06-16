
//Time Complexity:O(1)
import java.util.*;

class DisJointSet {
    int[] parent, rank;

    DisJointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
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
        if (pu == pv) {
            return;
        }
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

public class disjointSetbyUnion {
    public static void main(String[] args) {
        DisJointSet ds = new DisJointSet(7);
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        System.out.println(ds.findP(6));
        if (ds.findP(3) == ds.findP(7)) {
            System.out.println("Both belong to same component");
        } else {
            System.out.println("Not same");
        }
        ds.union(3, 7);
        if (ds.findP(3) == ds.findP(7)) {
            System.out.println("Both belong to same component");
        } else {
            System.out.println("Not same");
        }
    }
}
