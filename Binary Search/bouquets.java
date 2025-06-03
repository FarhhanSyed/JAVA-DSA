// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in
//exactly one bouquet.
// Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
//  If it is impossible to make m bouquets return -1.
public class bouquets {
    public static boolean checkBloom(int[] arr, int m, int k, int cur) {
        int cnt = 0;
        int noOfB = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= cur) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = m * k;
        if (val > n) {
            return -1;
        }
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            mini = Math.min(bloomDay[i], mini);
            maxi = Math.max(bloomDay[i], maxi);
        }
        int ans = -1;
        int s = mini;
        int h = maxi;
        while (s <= h) {
            int mid = (s + h) / 2;
            if (checkBloom(bloomDay, m, k, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 7, 7, 7, 12, 7, 7 };
        int m = 2;
        int k = 3;
        System.out.println(minDays(arr, m, k));
    }
}
