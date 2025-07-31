//Time Comp : O(log(start^goal))

public class minBitsToFlip {
    public static int minBits(int start, int goal) {
        int ans = start ^ goal;
        int cnt = 0;
        while (ans > 0) {
            cnt += (ans & 1);
            ans = ans >> 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        System.out.println(minBits(start, goal));
    }
}
