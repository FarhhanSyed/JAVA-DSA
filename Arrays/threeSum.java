import java.util.*;

public class threeSum {
    public static void sum(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            while (j < k) {

                int summ = arr[i] + arr[j] + arr[k];
                if (summ < 0) {
                    j++;
                } else if (summ > 0) {
                    k--;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(arr[i]);
                    tmp.add(arr[j]);
                    tmp.add(arr[k]);
                    list.add(tmp);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] arr = { -1, -2, 0, -1, -2, 0, -2, -1, 0, 1, 4, 2 };
        sum(arr);
    }
}