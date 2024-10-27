//Time-Complexity-O(n*l)
public class longestCommonPrefix {
    public static String prefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ref = strs[0];
        for (int i = 0; i < ref.length(); i++) {
            char cur = ref.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != cur) {
                    return ref.substring(0, i);
                }
            }
        }
        return ref;
    }

    public static void main(String args[]) {
        String strs[] = { "flower", "flow", "flight", "float" };
        System.out.println(prefix(strs));
    }
}