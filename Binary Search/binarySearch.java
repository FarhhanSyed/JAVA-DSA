import java.util.*;

public class binarySearch {
    public static int binsearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == arr[mid])
                return mid;
            else if (key < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String agrs[]) {
        System.out.println("Enter the number of elements:");
        ;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("The elements are:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Enter key element to search");
        int key = sc.nextInt();
        int r = binsearch(arr, key);
        if (r != -1) {
            System.out.println(key + " found at index " + r);
        } else {
            System.out.println(key + " not found");
        }

    }
}
