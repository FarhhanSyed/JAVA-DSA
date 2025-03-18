
//Given a binary array nums and an integer goal, return the number of non-empty subarrays
//with a sum goal.
//Time Complexity : O(2*2n)
//Space Complexity : O(1)
import java.util.*;

public class binarySubarraySum {
    public static int number(int[] nums, int goal) {
        return count(nums, goal) - count(nums, goal - 1);
    }

    public static int count(int[] nums, int goal) {
        int count = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(number(nums, goal));
    }
}