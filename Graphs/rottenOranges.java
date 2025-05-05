// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

//Time : O(n*m) 
//Space : O(n*m)

import java.util.*;

public class rottenOranges {
    static class Pair {
        int row;
        int col;
        int time;

        Pair(int r, int c, int t) {
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }

    public static int findMinimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visit = new int[n][m];
        int countFresh = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visit[i][j] = 2;
                } else {
                    visit[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    countFresh++;
            }
        }
        int tm = 0;
        int drow[] = { -1, 1, 0, 0 };
        int dcol[] = { 0, 0, 1, -1 };
        int cnt = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.remove();
            tm = Math.max(tm, t);
            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if (nr >= 0 && nr < n && nc < m && nc >= 0 && visit[nr][nc] != 2 && grid[nr][nc] == 1) {
                    q.add(new Pair(nr, nc, t + 1));
                    visit[nr][nc] = 2;
                    cnt++;
                }
            }
        }
        return (cnt == countFresh) ? tm : -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        System.out.println(findMinimumTime(grid));
    }
}