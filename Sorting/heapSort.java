import java.util.*;

public class heapSort {
    public static void heapify(List<Integer> arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if (left < n && arr.get(maxIdx) < arr.get(left)) {
            maxIdx = left;
        }
        if (right < n && arr.get(maxIdx) < arr.get(right)) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            int tmp = arr.get(i);
            arr.set(i, arr.get(maxIdx));
            arr.set(maxIdx, tmp);
            heapify(arr, n, maxIdx);
        }
    }

    public static void convertMaxHeap(List<Integer> arr) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void sort(List<Integer> arr) {
        convertMaxHeap(arr);
        int n = arr.size();
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, tmp);
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 5, 6, 3, 9 };
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            list.add(n);
        }
        System.out.println(list);
        sort(list);
        System.err.println(list);
    }
}
