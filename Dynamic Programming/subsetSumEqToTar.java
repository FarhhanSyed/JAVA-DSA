import java.util.*;

public class subsetSumEqToTar {
    public static boolean brute(int n, int[] arr, int sum) // brute-force
    {
        if (sum == 0) {
            return true;
        }
        if (n == 0)
            return (arr[0] == sum);
        boolean np = brute(n - 1, arr, sum);
        boolean p = false;
        if (arr[n] <= sum) {
            p = brute(n - 1, arr, sum - arr[n]);
        }
        return p || np;
    }

    public static int memoiz(int n, int[] arr, int sum, int[][] dp) { // memoization
        if (sum == 0) {
            return 1;
        }
        if (n == 0)
            return (arr[0] == sum) ? 1 : 0;
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        int np = memoiz(n - 1, arr, sum, dp);
        int p = -1;
        if (arr[n] <= sum) {
            p = memoiz(n - 1, arr, sum - arr[n], dp);
        }
        return Math.max(p, np);
    }

    public static int tabu(int n, int[] arr, int sum) { // tabulation
        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= sum) {
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                int np = dp[i - 1][j];
                int p = -1;
                if (arr[i] <= j) {
                    p = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = Math.max(np, p);
            }
        }
        return dp[n - 1][sum];
    }

    public static int optimz(int n, int[] arr, int sum) { // optimization
        int[] prev = new int[sum + 1];
        int[] cur = new int[sum + 1];
        if (arr[0] <= sum)
            prev[arr[0]] = 1;
        prev[0] = 1;
        for (int i = 1; i < n; i++) {
            cur[0] = 1;
            for (int j = 1; j <= sum; j++) {
                int np = prev[j];
                int p = -1;
                if (arr[i] <= j) {
                    p = prev[j - arr[i]];
                }
                cur[j] = Math.max(p, np);
            }
            prev = cur.clone();
        }
        return prev[sum];
    }

    public static void main(String[] args) {
        int[] arr = { 6, 1, 2, 3, 3, 6 };
        int k = 11;
        System.out.println(optimz(arr.length, arr, k));
    }
}