
//Find length of the longest subarray containing atmost two distinct integers
//Time Complexity : O(n)
//Space Complexity : O(3) as only 3 elements are stored in the map
import java.util.*;

public class fruitIntoBaskets {
    public static int max(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxLength = Integer.MIN_VALUE;
        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            if (map.size() > 2) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }
                l++;
            }
            maxLength = Math.max(maxLength, (r - l + 1));
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 5, 3, 1, 3, 5, 5, 3 };
        System.out.println(max(nums));
    }
}
