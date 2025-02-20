//Time Complexity-O(n)
//Space Complexity-O(n)

import java.util.*;

public class nextGreaterElement {
    public static void nge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[st.peek()];
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String args[]) {
        int[] arr = { 6, 8, 0, 1, 3 };
        nge(arr);
    }
}

// brute-force-O(n^2)
// public static void nge(int[] arr) {
// int[] ans = new int[arr.length];
// for (int i = 0; i < arr.length; i++) {
// int ele = arr[i];
// boolean flag = false;
// for (int j = i + 1; j < arr.length; j++) {
// if (arr[j] > ele) {
// flag = true;
// ans[i] = arr[j];
// break;
// }
// }
// if (!flag) {
// ans[i] = -1;
// }
// }
// System.out.println(Arrays.toString(ans));
// }