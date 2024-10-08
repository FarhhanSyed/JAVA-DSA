import java.util.*;

public class palindrome {
    public static boolean ispalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String st = "racecar";
        System.out.println(ispalindrome(st));
    }
}
