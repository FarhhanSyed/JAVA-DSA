//Ceiling - Smallest number that is greater than or equal to target
public class ceiling {
    public static int ceilingNumber(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return arr[s];
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 4, 5, 9, 14, 16, 18 };
        int target = 15;
        System.out.println(ceilingNumber(arr, target));
    }
}