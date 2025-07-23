import java.util.Arrays;

public class longestCommonSubsequence {
    public static int brute(String s1, String s2, int idx1, int idx2) { // brute-force
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return 1 + brute(s1, s2, idx1 - 1, idx2 - 1);
        }
        return Math.max(brute(s1, s2, idx1 - 1, idx2), brute(s1, s2, idx1, idx2 - 1));
    }

    public static int memoiz(String s1, String s2, int idx1, int idx2, int[][] dp) { // memoization
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + memoiz(s1, s2, idx1 - 2, idx2 - 1, dp);
        }
        return dp[idx1][idx2] = Math.max(memoiz(s1, s2, idx1 - 1, idx2, dp), memoiz(s1, s2, idx1, idx2 - 1, dp));
    }

    public static int tabu(String s1, String s2, int idx1, int idx2) { // tabulation
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[idx1][idx2];
    }

    public static int optimz(String s1, String s2, int idx1, int idx2) { //optimization
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(cur[j - 1], prev[j]);
                }
            }
            prev = cur.clone();
        }
        return prev[m];
    }

    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
        System.out.println(optimz(s1, s2, s1.length(), s2.length()));
    }
}
