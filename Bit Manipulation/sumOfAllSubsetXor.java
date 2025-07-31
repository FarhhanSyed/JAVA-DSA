public class sumOfAllSubsetXor {
    public static void func(int[] arr, int idx, int curXor, int[] tot) {
        if (idx == arr.length) {
            tot[0] += curXor;
            return;
        }
        func(arr, idx + 1, curXor ^ arr[idx], tot);
        func(arr, idx + 1, curXor, tot);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 1 };
        int[] curXor = { 0 };
        func(arr, 0, 0, curXor);
        System.out.println(curXor[0]);  
    }
}
