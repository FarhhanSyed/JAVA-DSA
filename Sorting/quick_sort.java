//Time Complexity-O(n logn)
public class quick_sort {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quick(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = part(arr, start, end);
        quick(arr, start, partition - 1);
        quick(arr, partition + 1, end);
    }

    public static int part(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[end] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 8, 2, 5 };
        quick(arr, 0, arr.length - 1);
        print(arr);
    }
}
