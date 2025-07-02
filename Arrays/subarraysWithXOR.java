import java.util.*;

public class subarraysWithXOR {
    public static int countSubarrays(int[] arr, int xor) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xorr = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            xorr ^= arr[i];
            if (xorr == xor) {
                count++;
            }
            if (map.containsKey(xorr ^ xor)) {
                count += map.get(xorr ^ xor);
            } else {
                map.put(xorr, map.getOrDefault(xorr, 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int xor = 6;
        System.out.println(countSubarrays(arr, xor));
    }
}
