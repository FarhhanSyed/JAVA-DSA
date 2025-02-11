
//Time Complexity-O(n)
import java.util.*;

public class duplicateParenthesis {
    public static boolean duplicate(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                int count = 0;
                while (st.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "(a+b)";
        System.out.println(duplicate(s));
    }
}
