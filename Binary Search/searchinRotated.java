public class searchinRotated {
    public static int pivot(int arr[]) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid < e && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > s && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[s] >= arr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static int binary(int arr[], int s, int e, int target) {
        boolean isAsc = false;
        if (arr[s] < arr[e]) {
            isAsc = true;
        }
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (target < arr[mid]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 3, 4, 5, 6, 7, 0, 1, 2 };
        int target = 2;
        int pivot = pivot(arr);
        int first = binary(arr, 0, pivot, target);
        if (first != -1) {
            System.out.println(binary(arr, 0, pivot, target));
        }
        System.out.println(binary(arr, pivot + 1, arr.length - 1, target));
    }
}
