import java.util.*;

class Edge implements Comparable<Edge> {
    int weight, u, v;

    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.weight = wt;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

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

public class kruskalsAlgorithm {
    public static int minSpanningTree(ArrayList<Edge> edges, int v) {
        int totalWeight = 0;
        Collections.sort(edges);
        DisjointSetUnion dsu = new DisjointSetUnion(v);
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (Edge e : edges) {
            if (dsu.findP(e.u) != dsu.findP(e.v)) {
                totalWeight += e.weight;
                dsu.union(e.u, e.v);
                edgeList.add(e);
            }
        }
        System.out.println("MST contains the following edges");
        for (Edge e : edgeList) {
            System.out.print("[" + e.u + "," + e.v + "]");
            System.out.print(",");
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        System.out.println(minSpanningTree(edges, v));
    }
}
