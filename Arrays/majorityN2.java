import java.util.*;

public class majorityN2 {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        int ele = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                ele = arr[i];
                cnt = 1;
            } else if (arr[i] == ele) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int ct = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele)
                ct++;
        }
        if (ct > arr.length / 2) {
            System.out.println("Element is :" + ele);
        } else {
            System.out.println("No element found");
        }
    }
}