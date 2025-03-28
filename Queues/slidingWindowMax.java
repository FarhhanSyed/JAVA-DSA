import java.util.*;

public class slidingWindowMax {
    public static void window(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.removeLast();
            }
            dq.addLast(r);
            if (dq.peekFirst() < l) {
                dq.removeFirst();
            }
            if ((r + 1) >= k) {
                res[l] = nums[dq.peekFirst()];
                l++;
            }
            r++;
        }
        System.out.println(Arrays.toString(res));
    }

    public static void main(String args[]) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        window(nums, k);
    }
}
