import java.util.*;

class Pair {
    int row;
    int col;
    int dis;

    Pair(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.dis = d;
    }
}

public class Matrix01 {
    public static int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visit = new boolean[n][m];
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    visit[i][j] = true;
                }
            }
        }
        int[] drow = { 1, -1, 0, 0 };
        int[] dcol = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int d = q.peek().dis;
            q.remove();
            res[r][c] = d;
            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.add(new Pair(nr, nc, d + 1));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] result = new int[mat.length][mat[0].length];
        result = updateMatrix(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
