
//Given a binary array nums and an integer k, return the maximum number of consecutive 1's 
//in the array if you can flip at most k 0's.
//Time Complexity : O(n)+O(n)=>O(n)
import java.util.*;

public class maxConsecOnes {
    public static int maxConsecutive(int[] nums, int k) {
        int l = 0, r = 0;
        int zeroes = 0;
        int maxLength = Integer.MIN_VALUE;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeroes++;
            }
            while (zeroes > k) {
                if (nums[l] == 0) {
                    zeroes--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(maxConsecutive(nums, k));
    }
}
