import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static void find(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                int k = j + 1;
                int l = arr.length - 1;
                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(arr[i]);
                        tmp.add(arr[j]);
                        tmp.add(arr[k]);
                        tmp.add(arr[l]);
                        list.add(tmp);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1]) {
                            k++;
                        }
                        while (k < l && arr[l] == arr[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        find(arr, target);
    }
}
