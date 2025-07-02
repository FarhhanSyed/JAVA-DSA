import java.util.*;

public class nextPermutation {
    public static void swap(int[] nums, int s, int e) {
        int tmp = nums[s];
        nums[s] = nums[e];
        nums[e] = tmp;
    }

    public static void reverse(int[] nums, int s, int e) {
        while (s < e) {
            swap(nums, s++, e--);
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, idx, i);
                break;
            }
        }
        reverse(nums, idx + 1, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
