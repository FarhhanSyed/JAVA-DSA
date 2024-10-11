
//Time Complexity:O(n)
import java.util.*;

public class stringCompression {
    public static String compress(String str) {
        Integer count = 0;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aabbccddd";
        System.out.println(compress(str));
    }
}
