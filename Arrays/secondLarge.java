//Time-Complexity:O(n)
public class secondLarge {
    public static int second(int arr[]) {
        if (arr.length < 2) {
            return -1;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        return second;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 76, 23, 98, 54, 23 };
        System.out.println(second(arr));
    }
}
