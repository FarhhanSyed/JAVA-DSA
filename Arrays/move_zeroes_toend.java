import java.util.*;

public class move_zeroes_toend {
    public static void move(int arr[]) {
        int n = arr.length;
        int i, j = 0;
        for (i = 0; i < n;) {
            if (arr[i] == 0)
                i++;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {
        int arr[] = { 1, 0, 4, 2, 0, 3, 2, 0 };
        move(arr);
    }
}
