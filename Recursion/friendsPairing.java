//Time Complexity-O(2^n)
public class friendsPairing {
    public static int pairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int single = pairing(n - 1);
        int pair = (n - 1) * pairing(n - 2);
        return single + pair;
    }

    public static void main(String[] args) {
        System.out.println(pairing(4));
    }
}
