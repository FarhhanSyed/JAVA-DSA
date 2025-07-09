import java.util.Arrays;

public class frogJumpII {
    public static int jump(int[] arr, int n, int k, int[] dp) {
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if (dp[n] != -1) {
            return dp[n];
        }
        for (int j = 1; j <= k; j++) {
            if (n - j >= 0) {
                int cost = jump(arr, n - j, k, dp) + Math.abs(arr[n] - arr[n - j]);
                min = Math.min(min, cost);
            }
        }
        dp[n] = min;
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = { 30, 20, 50, 10, 40 };
        int k = 3;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(jump(arr, arr.length-1, k, dp));
    }
}
