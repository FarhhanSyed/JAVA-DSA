//Floor - Largest number that is less than or equal to target
public class floor {
    public static int floorNumber(int arr[], int target) {
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
        return arr[e];
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 4, 5, 9, 14, 16, 18 };
        int target = 15;
        System.out.println(floorNumber(arr, target));
    }
}
