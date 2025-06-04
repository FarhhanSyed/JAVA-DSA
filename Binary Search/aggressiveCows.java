
// You are given an array with unique elements of stalls[], which denote the position of a stall.
// You are also given an integer k which denotes the number of aggressive cows. 
// Your task is to assign stalls to k cows such that the minimum distance between any two of them
// is the maximum possible.
import java.util.*;

public class aggressiveCows {
    public static boolean canWePlace(int[] arr, int cur, int k) {
        int last = arr[0];
        int cntCows = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= cur) {
                cntCows++;
                last = arr[i];
            }
        }
        return cntCows >= k;
    }

    public static int maxDistance(int[] arr, int k) {
        Arrays.sort(arr);
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        int s = 1;
        int e = maxi - mini;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (canWePlace(arr, mid, k)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 3, 4, 7, 10, 9 };
        int k = 4;
        System.out.println(maxDistance(arr, k));
    }
}
