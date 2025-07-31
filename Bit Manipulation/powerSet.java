//Time Comp : O(n* (2^n) )
//SPace Comp : O( (2^n) *n)

import java.util.*;

public class powerSet {
    public static ArrayList<ArrayList<Integer>> generate(int[] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i <= (1 << n) - 1; i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sub.add(arr[j]);
                }
            }
            list.add(sub);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(generate(arr));
    }
}
