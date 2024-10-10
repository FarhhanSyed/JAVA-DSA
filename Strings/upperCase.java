//convert the first letter of each word to uppercase
public class upperCase {
    public static String change(String str) {
        StringBuilder sb = new StringBuilder();
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            char c = sb.charAt(i);
            if (c == ' ' && i < str.length() - 1) {
                sb.append(c);
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(change(str));
    }
}
