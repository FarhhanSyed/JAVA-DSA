//Time Complexity:O(n^2)
import java.util.*;

public class selection_sort {
    public static void selection(int arr[]) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int small = i;
            for (int j = i + 1; j <= arr.length - 1; j++) 
                if (arr[j] < arr[small]) {
                    small = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String agrs[]) {
        int arr[] = { 5, 4, 1, 3, 2 };
        selection(arr);
    }
}
