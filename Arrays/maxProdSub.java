public class maxProdSub {
    public static int prod(int[] arr) {
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < arr.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix *= arr[i];
            suffix *= arr[arr.length - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, -3, 0, -4, -5 };
        System.err.println(prod(arr));
    }
}