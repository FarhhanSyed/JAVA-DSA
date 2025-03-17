
//Time Complexity : O(n)
//Space Complexity : O(n)
import java.util.*;

public class countSubarraySumK {
    public static int countSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int remove = prefixSum - k;
            if (map.containsKey(remove)) {
                count += map.get(remove);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
        int k = 3;
        System.out.println(countSubarray(nums, k));
    }
}
