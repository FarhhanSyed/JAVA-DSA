public class largestString {
    public static void getLargest(String str[]) {
        int length = str[1].length();
        String large = str[0];
        for (int i = 1; i < str.length; i++) {
            if (large.compareTo(str[i]) < 0) {
                large = str[i];
            }
        }
        System.out.println(large);
    }

    public static void main(String[] args) {
        String str[] = { "apple", "bannana", "zaa", "grapes" };
        getLargest(str);
    }
}
