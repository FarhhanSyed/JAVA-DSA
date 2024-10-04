//TIme Complexity:O(2n)
import java.util.*;

public class rotate_array {
    public static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int arr[], int k) {
        int n = arr.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        reverse(arr, 0, n - k - 2);
        reverse(arr, n - k - 1, n - 1);
        reverse(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotate(arr, k);
    }
}
