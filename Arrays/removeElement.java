//Time Complexity:O(n)
import java.util.*;

public class removeElement {
    public static int remove(int arr[], int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target) {
                arr[count] = arr[i];
                count++;
            }
        }
        for (int j = 0; j < count; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int target = 2;
        int k = remove(arr, target);
        System.out.println("The number of elements after removing the target element are " + k);
    }
}
