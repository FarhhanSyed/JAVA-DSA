import java.util.Arrays;

public class houseRobber {
    public static int memoization(int[] arr, int n, int[] dp) { //memoization
        if (n == 0)
            return arr[0];
        if (dp[n] != -1) {
            return dp[n];
        }
        int pick = arr[n];
        if (n > 1)
            pick += memoization(arr, n - 2, dp);
        int notPick = memoization(arr, n - 1, dp);
        return dp[n] = Math.max(pick, notPick);

    }

    public static int tabulation(int[] arr) { //tabulation
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[arr.length - 1];
    }

    public static int rob(int[] arr) { // space-opt
        int p = arr[0];
        int p2 = 0;
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += p2;
            int notPick = p;
            int cur = Math.max(pick, notPick);
            p2 = p;
            p = cur;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 9, 3, 1 };
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(tabulation(arr));
    }
}
