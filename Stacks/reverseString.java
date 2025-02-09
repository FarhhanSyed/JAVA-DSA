
//Time complexity-O(n)
//Space complexity-O(n)
import java.util.*;

public class reverseString {
    public static String reverse(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            st.push(c);
        }
        StringBuilder reversedString = new StringBuilder();
        while (!st.isEmpty()) {
            reversedString.append(st.pop());
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(reverse(s));
    }
}
