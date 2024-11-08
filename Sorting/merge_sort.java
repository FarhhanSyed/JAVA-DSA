
//Time Complexity-O(n logn)
import java.util.*;

public class merge_sort {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int arr[], int start, int mid, int end) {
        int i = start;
        int k = 0;
        int j = mid + 1;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0, i = start; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        mergeSort(arr, 0, arr.length - 1);
        print(arr);
    }
}
