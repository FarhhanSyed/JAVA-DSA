public class palindrome {
    public static boolean palind(String str,int i)
    {
        int n=str.length();
        if(i>n/2)
        {
            return true;
        }
        if(str.charAt(i)!=str.charAt(n-i-1))
        {
            return false;
        }
        return palind(str, i+1);
    }
    public static void main(String[] args) {
        System.out.println(palind("MADAM", 0));
    }
}
