import java.util.*;

public class search_insert_position {
    public static int searchInsert(int[] nums, int target) {
        int res = -1;
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                return res;
            } else if (target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        int i;
        if (res == -1) {
            for (i = 0; i < n; i++) {
                if (target > nums[i]) {
                    continue;
                } else {
                    res = i;
                    break;
                }
            }
        }
        if (target > nums[n - 1]) {
            res = n;
        }
        return res;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 5, 6 };
        int target = 7;
        int index = searchInsert(arr, target);
        System.out.println(index);
    }
}
