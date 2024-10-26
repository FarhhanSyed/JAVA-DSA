//Time Comeplexity-O(log n)
public class power {
    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPoq = pow(x, n / 2);
        int halfPowSqr = halfPoq * halfPoq;
        if (n % 2 != 0) {
            halfPowSqr = x * halfPowSqr;
        }
        return halfPowSqr;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }
}

// Time-Complexity:O(n)
// public static int power(int x, int n) {
// if (n == 0) {
// return 1;
// }
// return x * power(x, n - 1);
// }