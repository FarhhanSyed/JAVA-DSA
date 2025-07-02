
//Time Complexity : O(n)
import java.util.*;

public class frogJump {
    public static int jump(int n, int[] arr, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int oneStep = jump(n - 1, arr, dp) + Math.abs(arr[n] - arr[n - 1]);
        int twoStep = Integer.MAX_VALUE;
        if (n > 1) {
            twoStep = jump(n - 2, arr, dp) + Math.abs(arr[n] - arr[n - 2]);
        }
        dp[n] = Math.min(oneStep, twoStep);
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = { 30, 20, 50, 10, 40 };
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        System.out.println(jump(arr.length - 1, arr, dp));
    }
}
