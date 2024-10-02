//Time Complexity:O(n)
import java.util.*;

public class sortedandRotated {
    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
                if (count > 1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        System.out.println(check(arr));
    }
}
