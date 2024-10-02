//Time Complexity:O(n)
import java.util.*;

public class remove_duplicates {
    public static int remove(int arr[]) {
        int n = arr.length;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3 };
        int k = remove(arr);
        System.out.println("Number of unique elements are " + k);
    }
}
