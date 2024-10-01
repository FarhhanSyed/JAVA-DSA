//TIme COmolexity:O(log n)
import java.util.*;

public class BinarySearch {
    public static int binary(int arr[], int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 4, 6, 8, 10, 12, 14 };
        int key = 4;
        int r = binary(arr, key, 0, arr.length - 1);
        if (r != -1) {
            System.out.println("Key found at index :" + r);
        } else {
            System.out.println("Key not found");
        }
    }
}
