import java.util.*;

public class longestCommonSubstring {
    public static int longestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int maxLen = Integer.MIN_VALUE;
        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static void main(String args[]) {
        String s = "abacabcbb";
        System.out.println(longestSubstring(s));
    }
}
