public class kokoBannanas {
    public static int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public static long calculate(int[] piles, int h, int cur) {
        long total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += (long) Math.ceil((double) piles[i] / cur);
        }
        return total;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = findMax(piles);
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            long val = calculate(piles, h, mid);
            if (val <= h) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}
