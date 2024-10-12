import java.util.*;

public class reverseWords {
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder("");
        String nam[] = s.trim().split("\\s+");
        for (int i = nam.length - 1; i >= 0; i--) {
            if (nam[i].equals(" ")) {
                continue;
            }
            sb.append(nam[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = " hello world   hi";
        System.out.println(reverse(s));
    }
}
