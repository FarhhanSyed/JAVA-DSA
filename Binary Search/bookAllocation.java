public class bookAllocation {
    public static int isPossible(int[] arr, int k, int cur) {
        int sum = 0;
        int st = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum <= cur) {
                continue;
            } else {
                st++;
                sum = arr[i];
            }
        }
        if (sum <= arr[arr.length - 1]) {
            st++;
        }
        return st;
    }

    public static int allocation(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxi = Math.max(maxi, arr[i]);
        }
        int s = maxi;
        int e = sum;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (isPossible(arr, k, mid) > k) {

                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] arr = { 25, 46, 28, 49, 24 };
        int k = 4;
        System.out.println(allocation(arr, k));
    }
}
