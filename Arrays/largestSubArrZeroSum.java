import java.util.*;

public class largestSubArrZeroSum {
    public static int findLargest(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int large = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                large = Math.max(large, i + 1);
            }
            if (map.containsKey(sum)) {
                large = Math.max(large, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return large;
    }

    public static void main(String[] args) {
        int arr[] = { 9, -3, 3, -1, 6, -5 };
        System.out.println(findLargest(arr));
    }
}