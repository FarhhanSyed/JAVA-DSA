import java.util.*;

public class searchinRotatedII {
    public static boolean search(int[] arr, int target) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[l] == arr[mid] && arr[mid] == arr[h]) {
                l++;
                h++;
                continue;
            }
            if (arr[l] <= arr[mid]) {
                if (target >= arr[l] && target <= arr[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target >= arr[mid] && target <= arr[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 3, 3, 3, 3 };
        int target = 1;
        System.out.println(search(arr, target));
    }
}
