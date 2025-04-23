
// Each child i has a greed factor g[i], which is the minimum size of a cookie that the child 
// will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the
// cookie j to the child i, and the child i will be content.
import java.util.*;

public class assignCookies {
    public static int assign(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int l = 0;
        int r = 0;
        while (l < g.length && r < s.length) {
            if (g[l] <= s[r]) {
                count++;
                l++;
            }
            r++;
        }
        return count;
    }

    public static void main(String args[]) {
        int[] g = { 1, 2, 3 };
        int[] s = { 1, 1 };
        System.out.print(assign(g, s));
    }
}
