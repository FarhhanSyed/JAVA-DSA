import java.util.*;

public class insertInterval {
    public static void insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] < newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        int[][] g = res.toArray(new int[res.size()][]);
        for (int j = 0; j < n; j++) {
            System.out.print(g[0]);
            System.out.print(g[1]);
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        insert(intervals, newInterval);
    }
}
