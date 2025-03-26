import java.util.*;

public class firstNonRepeating {
    public static List<Character> nonrepeating(String s) {
        ArrayList<Character> list = new ArrayList<>();
        Queue<Character> q = new ArrayDeque<>();
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            q.add(s.charAt(i));
            map[s.charAt(i) - 'a']++;
            while (!q.isEmpty() && map[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (!q.isEmpty()) {
                list.add(q.peek());
            } else {
                list.add(null);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        String s = "aabccxb";
        System.out.println(nonrepeating(s));
    }
}
