
//Time Complexity-O(n*m)
//Space Complexity-O(n)
import java.util.*;

public class maxAreaHistogramInBinaryMat {
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
        while (!st.isEmpty()) {
            int val = st.pop();
            int nsr = n;
            int nsl = st.isEmpty() ? -1 : st.peek();
            area = Math.max(area, heights[val] * (nsr - nsl - 1));
        }
        return area;
    }

    public static int maxArea(int mat[][]) {
        int area = maxAreaHistogram(mat[0]);
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                } else {
                    mat[i][j] = 0;
                }

            }
            area = Math.max(area, maxAreaHistogram(mat[i]));
        }
        return area;
    }

    public static void main(String[] args) {
        int mat[][] = { { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 } };
        System.out.println(maxArea(mat));
    }
}
