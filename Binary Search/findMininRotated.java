public class findMininRotated {
    public static int findMin(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[l] <= arr[mid]) {
                ans = Math.min(ans, arr[l]);
                l = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                h = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(arr));
    }
}