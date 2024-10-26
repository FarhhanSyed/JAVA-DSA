import java.util.Arrays;

public class reverseArray {
    public static int[] reverse(int arr[], int i) {
        int n = arr.length;
        if (i >= n / 2) {
            return arr;
        }
        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;
        return reverse(arr, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int result[] = reverse(arr, 0);
        System.out.println(Arrays.toString(result));
    }
}
