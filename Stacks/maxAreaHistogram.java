
//Time Complexity-O(2n)
//Space Complexity-O(n)
import java.util.*;

public class maxAreaHistogram {
    public static int maxAreaHistogram(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int area = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int val = st.pop();
                int nsr = i;
                int nsl = st.isEmpty() ? -1 : st.peek();
                area = Math.max(area, heights[val] * (nsr - nsl - 1));
            }
            st.push(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(maxAreaHistogram(heights));
    }
}
