import java.util.*;

public class minRopes {
    public static int rope(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr) {
            pq.add(n);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int a = pq.remove();
            int b = pq.remove();
            int add = a + b;
            sum += add;
            pq.add(add);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 6 };
        System.out.println(rope(arr));
    }
}
