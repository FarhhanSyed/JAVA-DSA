// The upper bound algorithm finds the first or the smallest index in a sorted array
//  where the value at that index is greater than the given key i.e. x.

// The upper bound is the smallest index, ind, where arr[ind] > x.
// But if any such index is not found, the upper bound algorithm returns n i.e. size of the given array
public class upperBound {
    public static int bound(int[] arr, int k) {
        int res = arr.length - 1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > k) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7, 8, 8, 11, 11, 11, 12 };
        int k = 10;
        System.out.println(bound(arr, k));
    }
}
