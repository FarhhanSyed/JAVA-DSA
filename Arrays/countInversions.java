public class countInversions {
    public static int mergeSort(int[] arr, int s, int e) {
        int res = 0;
        if (s < e) {
            int mid = s + (e - s) / 2;
            res += mergeSort(arr, s, mid);
            res += mergeSort(arr, mid + 1, e);
            res += merge(arr, s, mid, e);
        }
        return res;
    }

    public static int merge(int[] arr, int s, int m, int e) {
        int res = 0;
        int k = 0;
        int i = s;
        int j = m + 1;
        int tmp[] = new int[e - s + 1];
        while (i <= m && j <= e) {
            if (arr[i] > arr[j]) {
                res += (m - i + 1);
                tmp[k] = arr[j];
                j++;
                k++;
            } else {
                tmp[k] = arr[i];
                i++;
                k++;
            }
        }
        while (i <= m) {
            tmp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= e) {
            tmp[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0, i = s; k < tmp.length; k++, i++) {
            arr[i] = tmp[k];
        }
        return res;
    }

    public static int inversionCount(int arr[]) {
        int res = mergeSort(arr, 0, arr.length - 1);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 5 };

    }
}
