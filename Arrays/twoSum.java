import java.util.*;

public class twoSum {
    public static int[] sum(int[] arr, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                ans[0] = map.get(target - arr[i]);
                ans[1] = i;
                return ans;
            } else {
                map.put(arr[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(sum(arr, target)));
    }
}