public class subsequence {
    public static boolean sub(String s, String t) {
        int spointer = 0;
        int tpointer = 0;
        while (spointer < s.length() && tpointer < t.length()) {
            if (s.charAt(spointer) == t.charAt(tpointer)) {
                tpointer++;
            }
            spointer++;
        }
        if (tpointer == t.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "abd";
        System.out.println(sub(s, t));
    }
}
