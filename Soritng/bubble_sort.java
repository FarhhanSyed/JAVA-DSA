//Timr Complexity:O(n^2)
import java.util.*;

public class bubble_sort {
    public static void bubble(int arr[]) {
        int n = arr.length;
        for (int turn = 0; turn <= n - 2; turn++) {
            for (int j = 0; j <= n - 2 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = { 4, 6, 2, 7, 3, 1 };
        bubble(arr);
    }
}

//for sorted array//
// public class bubble_sort {
//     public static void bubble(int arr[]) {
//         int n = arr.length;
//         boolean swap = false;
//         for (int turn = 0; turn <= n - 2; turn++) {
//             swap = false;
//             for (int j = 0; j <= n - 2 - turn; j++) {
//                 if (arr[j] > arr[j + 1]) {
//                     int temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                     swap = true;
//                 }
//             }
//             if (!swap) {
//                 break;
//             }
//         }
//         System.out.println(Arrays.toString(arr));
//     }
