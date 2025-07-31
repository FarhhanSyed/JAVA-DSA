public class XORLtoR {
    public static int func(int n) {
        if (n % 4 == 1)
            return 1;
        else if (n % 4 == 2)
            return n + 1;
        else if (n % 4 == 3)
            return 0;
        else if (n % 4 == 4)
            return n;
        return -1;
    }

    public static int range(int l, int r) {
        int x = func(l - 1);
        int y = func(r);
        return x ^ y;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(func(n));
        System.out.println(range(2, 6));
    }
}