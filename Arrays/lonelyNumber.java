import java.util.*;

public class lonelyNumber {
    public static ArrayList lonely(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isLonely = true;
            if (i > 0 && arr[i] - arr[i - 1] <= 1) {
                isLonely = false;
            }
            if (i < n - 1 && arr[i + 1] - arr[i] <= 1) {
                isLonely = false;
            }
            if (isLonely == true) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 7, 3, 9 };
        System.out.println(lonely(arr));
    }
}
