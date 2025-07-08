import java.util.*;

public class repeatingAndMissing {
    public static List<Integer> better(int[] arr) { // TC:O(2n) SC:O(n)
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int[] hashArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hashArr[arr[i]]++;
        }
        int missing = -1;
        int repeating = -1;
        for (int i = 0; i < n; i++) {
            if (i != 0 && hashArr[i] == 2) {
                repeating = i;
            } else if (i != 0 && hashArr[i] == 0) {
                missing = i;
            }
        }
        list.add(repeating);
        list.add(missing);
        return list;
    }

    public static List<Integer> optimal(int[] arr) { // TC:O(n) SC:O(1)
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        long sn = (n * (n + 1)) / 2;
        long s2n = (n * (n + 1) * (2 * n + 1)) / 6;
        long s = 0;
        long s2 = 0;
        for (int i = 0; i < n; i++) {
            s += (long) arr[i];
            s2 += (long) arr[i] * arr[i];
        }
        long val1 = s - sn;
        long val2 = s2 - s2n;
        val2 = val2 / val1;
        long repeating = (val2 + val1) / 2;
        long missing = repeating - val1;
        list.add((int) (repeating));
        list.add((int) (missing));
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 3 };
        System.out.println(optimal(arr));
    }
}
