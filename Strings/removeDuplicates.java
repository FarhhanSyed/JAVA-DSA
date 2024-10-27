//Time Complexity-O(n^2)
public class removeDuplicates {
    public static String remove(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean isDuplicate = false;
            for (int j = 0; j < res.length(); j++) {
                if (res.charAt(j) == ch) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                res += str.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(remove(str));
    }
}
