import java.util.*;

public class nearbyCars {
    public static void cars(int[][] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            int dist = (x ^ 2) + (y ^ 2);
            pq.add(new int[] { dist, i });
            if (pq.size() > k) {
                pq.remove();
            }
        }
        for (int i = 0; i < k; i++) {
            int idx = pq.remove()[1];
            System.out.println(Arrays.toString(arr[idx]));
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        cars(arr, k);
    }
}
