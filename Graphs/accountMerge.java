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

public class accountMerge {
    public static ArrayList<ArrayList<String>> merge(ArrayList<ArrayList<String>> acc) {
        DisJointSet dsu = new DisJointSet(acc.size());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < acc.size(); i++) {
            for (int j = 1; j < acc.get(i).size(); j++) {
                String mail = acc.get(i).get(j);
                if (map.containsKey(acc.get(i).get(j))) {
                    dsu.union(map.get(mail), i);
                } else {
                    map.put(mail, i);
                }
            }
        }
        ArrayList<String>[] mer = new ArrayList[acc.size()];
        for (int i = 0; i < acc.size(); i++) {
            mer[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            int p = it.getValue();
            int up = dsu.findP(p);
            mer[up].add(it.getKey());
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (int i = 0; i < acc.size(); i++) {
            if (mer[i].size() == 0)
                continue;
            Collections.sort(mer[i]);
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(acc.get(i).get(0));
            for (String s : mer[i]) {
                tmp.add(s);
            }
            ans.addLast(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[][] accounts = { { "Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co" },
                { "Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co" },
                { "Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co" },
                { "Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co" },
                { "Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co" } };
        ArrayList<ArrayList<String>> scc = new ArrayList<>();
        for (String[] s : accounts) {
            scc.add(new ArrayList<>(Arrays.asList(s)));
        }
        System.out.println(merge(scc));
    }
}
