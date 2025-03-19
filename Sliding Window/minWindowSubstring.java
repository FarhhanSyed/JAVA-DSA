
//Time-Complexity : O(2m)+O(n),m-s.lenght(),n-t,length()
//Space-Complexity : O(256)
import java.util.*;

public class minWindowSubstring {
    public static String minWindow(String s, String t) {
        int[] map = new int[256];
        int count = 0;
        int idx = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            if (map[s.charAt(r)] <= 0) {
                map[s.charAt(r)]--;
            } else if (map[s.charAt(r)] > 0) {
                map[s.charAt(r)]--;
                count++;
            }
            while (count == t.length()) {
                if ((r - l + 1) < minLen) {
                    minLen = Math.min(minLen, (r - l + 1));
                    idx = l;
                }
                map[s.charAt(l)]++;
                if (map[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return idx == -1 ? "" : s.substring(idx, idx + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
