import java.util.Arrays;

public class sort012 {
    public static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 0, 2, 1, 0, 0, 1 };
        int l = 0;
        int m = 0;
        int h = nums.length - 1;
        while (m <= h) {
            if (nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } else if (nums[m] == 1) {
                m++;
            } else {
                swap(nums, m, h);
                h--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
