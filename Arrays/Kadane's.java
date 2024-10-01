//TIme Complexity:O(n)
public class kadanes {
    public static void subarrSum(int arr[]) {
        int sum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > max) {
                max = sum;
            }

        }
        System.out.println("Max: " + max);
    }

    public static void main(String args[]) {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        subarrSum(arr);
    }
}

