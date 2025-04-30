import java.util.ArrayList;
import java.util.Arrays;

public class mergeInterval {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        res.add(intervals[i]);
        i++;
        while (i < intervals.length) {
            int curE = intervals[i - 1][1];
            int x = res.get(i - 1)[1];
            if (intervals[i][0] <= x) {
                curE = intervals[i][1];
                res.get(i - 1)[1] = curE;
            } else {
                res.add(intervals[i]);
            }
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.print("[" + res[i][0] + "," + res[i][1] + "]");
        }
    }
}
