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
    public static int findCheapestFlight(int[][] flights, int n, int src, int dst, int k) {
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
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<PairCh> q = new LinkedList<>();
        distance[src] = 0;
        q.add(new PairCh(src, 0, 0));
        while (!q.isEmpty()) {
            int s = q.peek().source;
            int price = q.peek().dist;
            int brk = q.peek().stops;
            q.remove();
            for (Pi p : graph.get(s)) {
                int adjNode = p.dest;
                int adjPrice = p.price;
                if (brk > k)
                    continue;
                if (distance[adjNode] > price + adjPrice && brk <= k) {
                    distance[adjNode] = price + adjPrice;
                    q.add(new PairCh(adjNode, price + adjPrice, brk + 1));
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestFlight(flights, n, src, dst, k));
    }
}
