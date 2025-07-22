public class houseRobberII {
    public static int brute(int s, int n, int[] arr) // brute-force
    {
        if (n == s)
            return arr[0];
        if (n < s)
            return 0;
        int pick = brute(s, n - 2, arr) + arr[n];
        int not = brute(s, n - 1, arr);
        return Math.max(pick, not);
    }

    public static int memoiz(int s, int n, int[] arr, int[] dp) // memoization
    {
        if (n == s)
            return arr[0];
        if (n < s)
            return 0;
        if (dp[n] != -1) {
            return dp[n];
        }
        int pick = memoiz(s, n - 2, arr, dp) + arr[n];
        int not = memoiz(s, n - 1, arr, dp);
        return dp[n] = Math.max(pick, not);
    }

    public static int spaceOpt(int s, int n, int[] arr) // space-optm
    {
        int p2 = 0;
        int p = arr[s];
        for (int i = s + 1; i <= n; i++) {
            int pick = arr[i];
            if (i - 2 >= s)
                pick += p2;
            int np = p;
            int cur = Math.max(pick, np);
            p2 = p;
            p = cur;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 2 };
        int res = Math.max(spaceOpt(0, arr.length - 2, arr), spaceOpt(1, arr.length - 1, arr));
        System.out.println(res);
    }
}
