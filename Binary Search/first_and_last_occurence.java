//Time Complexity:O(log n)
import java.util.*;

public class first_and_last_position {
    public static int left(int arr[], int key) {
        int res1 = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == arr[mid]) {
                res1 = mid;
                end = mid - 1;
            } else if (key < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return res1;
    }

    public static int right(int arr[], int key) {
        int res2 = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == arr[mid]) {
                res2 = mid;
                start = mid + 1;
            } else if (key < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return res2;
    }

    public static int[] search(int arr[], int key) {
        int left = left(arr, key);
        int right = right(arr, key);
        return new int[] { left, right };
    }

    public static void main(String[] args) {
        int arr[] = { 5, 7, 7, 8, 8, 10 };
        int target = 7;
        System.out.println(Arrays.toString(search(arr, target)));
    }
}
