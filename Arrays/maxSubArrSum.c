public class maxSubArrSum {
    // TIme complexity:O(n3)
    public static void maxSum(int arr[]) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                curSum = 0;
                for (int k = start; k <= end; k++) {
                    curSum += arr[k];
                }
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }
        System.out.println("max Sum:" + maxSum);
    }

    // optimised method
    // Time complexity:O(n2)
    public static void prefixarr(int arr[]) {
        int cursum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                cursum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
            }
            if (cursum > maxSum) {
                maxSum = cursum;
            }
        }
        System.out.println("Max Sum:" + maxSum);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        maxSum(arr);
        prefixarr(arr);
    }
}
