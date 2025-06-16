import java.util.*;

class DisJointSetSize {
    int[] size, parent;

    DisJointSetSize(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
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
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

public class disjointSetbySize {
    public static void main(String[] args) {
        DisJointSetSize ds = new DisJointSetSize(7);
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
