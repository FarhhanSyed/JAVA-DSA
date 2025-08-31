import java.util.*;

public class topKFreq {
    public static int[] topK(int[] arr, int k) { // hashmap+sorting
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int[][] group = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            group[i][0] = it.getKey();
            group[i][1] = it.getValue();
            i++;
        }
        Arrays.sort(group, (a, b) -> b[1] - a[1]);
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = group[j][0];
        }
        return res;
    }

    public static int[] topKFrequent(int[] arr, int k) // hashmap+minHeap
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            minHeap.add(it);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.remove().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 4, 4, 4, 6, 6, 2, 2, 2, 8 };
        int k = 2;
        topKFrequent(arr, k);
    }
}
