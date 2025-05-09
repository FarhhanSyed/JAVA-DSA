// You are given an image represented by an m x n grid of integers image, where image[i][j] 
// represents the pixel value of the image. You are also given three integers sr, sc, and color. 
// Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

// To perform a flood fill:

// 1.Begin with the starting pixel and change its color to color.
// 2.Perform the same process for each pixel that is directly adjacent 
// (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
// 3.Keep repeating this process by checking neighboring pixels of the updated pixels and modifying 
// their color if it matches the original color of the starting pixel.
// 4.The process stops when there are no more adjacent pixels of the original color to update.

// Return the modified image after performing the flood fill.

import java.util.*;

public class floodFill {
    public static void dfs(int[][] image, int[] drow, int[] dcol, int color, int originalColor, int sr, int sc) {
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nr = sr + drow[i];
            int nc = sc + dcol[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] != color && image[nr][nc] == originalColor) {
                image[nr][nc] = color;
                dfs(image, drow, dcol, color, originalColor, nr, nc);
            }
        }
    }

    public static void main(String[] args) {
        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int color = 2;
        int originalColor = image[sr][sc];
        int drow[] = { 0, 0, 1, -1 };
        int dcol[] = { 1, -1, 0, 0 };
        image[sr][sc] = color;
        dfs(image, drow, dcol, color, originalColor, sr, sc);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
