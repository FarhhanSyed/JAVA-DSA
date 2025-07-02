
import java.util.Arrays;

public class fibonacci {
    public static int fib(int n, int[] arr) { // TC:O(n),SC:O(n)
        if (n <= 1)
            return n;
        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = fib(n - 1, arr) + fib(n - 2, arr);
        return arr[n];
    }

    public static int spaceOpt(int n) { // TC:O(n),SC:O(1)
        if (n <= 1)
            return n;
        int cur = 0;
        int prev = 1;
        int prev2 = 0;
        for (int i = 2; i <= n; i++) {
            cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        System.out.println(spaceOpt(n));
    }
}