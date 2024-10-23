import java.util.Arrays;

public class plusOne {
    public static int[] plus1(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < 9) {
                nums[i]++;
                return nums;
            }
            nums[i] = 0;
        }
        nums = new int[n + 1];
        nums[0] = 1;
        return nums;
    }

    public static void main(String args[]) {
        int nums[] = { 9, 9, 9 };
        System.out.println(Arrays.toString(plus1(nums)));
    }
}
