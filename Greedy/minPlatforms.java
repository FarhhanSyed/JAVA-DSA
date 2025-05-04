import java.util.*;

public class minPlatforms {
    public static int numberofPlatforms(int[] arr, int[] dept) {
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] < dept[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dept = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(numberofPlatforms(arr, dept));
    }
}
