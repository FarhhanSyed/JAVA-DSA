import java.util.*;

public class printSubsequence {
    public static void subsequence(String str, int idx, StringBuilder sb) {
        if (idx >= str.length()) {
            System.out.println(sb.toString());
            return;
        }
        sb.append(str.charAt(idx));
        subsequence(str, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        subsequence(str, idx + 1, sb);
    }

    public static void main(String[] args) {
        String str = "abc";
        subsequence(str, 0, new StringBuilder());
    }
}
