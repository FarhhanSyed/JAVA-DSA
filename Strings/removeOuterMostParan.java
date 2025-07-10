public class removeOuterMostParan {
    public static String removeOuter(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0)
                    sb.append(c);
                depth++;
            } else {
                depth--;
                if (depth > 0)
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(()())";
        System.out.println(removeOuter(s));
    }
}