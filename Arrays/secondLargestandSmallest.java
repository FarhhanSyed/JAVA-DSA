import java.util.*;

public class secondLargestandSmallest {
    public static int secondL(int arr[]) {
        int largest = arr[0];
        int slargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                slargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > slargest) {
                slargest = arr[i];
            }
        }
        return slargest;
    }

    public static int secondS(int arr[]) {
        int smallest = arr[0];
        int ssmallest = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                ssmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] > smallest && arr[i] < ssmallest) {
                ssmallest = arr[i];
            }
        }
        return ssmallest;
    }

    public static int[] seclargestandSmallest(int arr[]) {
        int Slargest = secondL(arr);
        int Ssmallest = secondS(arr);
        return new int[] { Slargest, Ssmallest };
    }

    public static void main(String[] args) {
        int arr[] = { 3, 7, 5, 3, 7, 9 };
        int res[] = seclargestandSmallest(arr);
        System.out.println("Seconds largest and second smallest elements are : " + Arrays.toString(res));
    }
}
