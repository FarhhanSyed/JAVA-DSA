//Time Coomplexity:O(n^2)
import java.util.*;

public class insertion_sort {
    public static void insertion(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int cur = arr[i];
            int prev = i - 1;
            // finding out correct position to insert
            while (prev >= 0 && cur < arr[prev]) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev + 1] = cur;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {
        int[] arr = { 2, 5, -2, 6, 0, 4, 1 };
        insertion(arr);
    }
}
