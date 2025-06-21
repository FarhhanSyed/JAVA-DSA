import java.util.*;

class PairCh {
    int source;
    int dist;
    int stops;

    PairCh(int s, int d, int st) {
        this.source = s;
        this.dist = d;
        this.stops = st;
    }
}

class Pi {
    int dest;
    int price;

    Pi(int d, int p) {
        this.dest = d;
        this.price = p;
    }
}

public class cheapestFlight {
    public static int findCheapestFlight(ArrayList<ArrayList<Pi>> graph, int n, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<PairCh> q = new LinkedList<>();
        q.add(new PairCh(src, 0, 0));
        while (!q.isEmpty()) {
            int nn = q.peek().source;
            int cost = q.peek().dist;
            int st = q.peek().stops;
            q.remove();
            if (st > k)
                continue;
            for (Pi p : graph.get(nn)) {
                int adjN = p.dest;
                int adjCost = p.price;
                if (dist[nn] + adjCost <= dist[adjN]) {
                    dist[adjN] = dist[nn] + adjCost;
                    q.add(new PairCh(adjN, adjCost + dist[nn], st + 1));
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;
        ArrayList<ArrayList<Pi>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] info : flights) {
            int source = info[0];
            int dest = info[1];
            int price = info[2];
            graph.get(source).add(new Pi(dest, price));
        }
        System.out.println(findCheapestFlight(graph, n, src, dst, k));
    }
}
