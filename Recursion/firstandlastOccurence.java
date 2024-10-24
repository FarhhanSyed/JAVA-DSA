import java.util.Arrays;

public class firstandlastOccurence {
    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return lastOccurence(arr, key, i - 1);
    }

    public static int[] firstandlast(int arr[]) {
        int idx1 = firstOccurence(arr, 5, 0);
        int idx2 = lastOccurence(arr, 5, arr.length - 1);
        return new int[] { idx1, idx2 };
    }

    public static void main(String[] args) {
        int arr[] = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        System.out.println(Arrays.toString(firstandlast(arr)));
    }
}
