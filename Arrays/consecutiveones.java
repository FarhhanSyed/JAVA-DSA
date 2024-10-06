import java.util.*;

public class consecutiveones {
    public static int consec(int arr[]) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
            }
            max = Math.max(max, count);
            if (arr[i] == 0) {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 1, 1, 1 };
        System.out.println(consec(arr));
    }
}
