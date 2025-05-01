import java.util.*;

public class nonOverlappingIntervals {
    public static int nonOverlapping(int[][] inter) {
        Arrays.sort(inter, (a, b) -> a[0] - b[0]);
        int count = 0;
        int i = 1;
        int prev = inter[0][1];
        while (i < inter.length) {
            if (inter[i][0] < prev) {
                count++;
            } else {
                prev = inter[i][1];
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(nonOverlapping(intervals));
    }
}
