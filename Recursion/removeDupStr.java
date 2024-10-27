//Time Complexity-O(n)
public class removeDupStr {
    public static void remove(String str, StringBuilder newstr, int idx, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newstr);
            return;
        }
        char cur = str.charAt(idx);
        if (cur >= 'a' && cur <= 'z') {
            if (map[cur - 'a'] == true) {
                remove(str, newstr, idx + 1, map);
            } else {
                map[cur - 'a'] = true;
                remove(str, newstr.append(cur), idx + 1, map);
            }
        } else {
            remove(str, newstr.append(cur), idx + 1, map);
        }
    }

    public static void main(String[] args) {
        String str = "bannanas";
        StringBuilder sb = new StringBuilder("");
        boolean map[] = new boolean[26];
        remove(str, sb, 0, map);
    }
}
