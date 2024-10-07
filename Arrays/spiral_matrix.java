//Time-Complexity:O(n*m)
import java.util.*;
public class spiral_matrix {
    public static void spirl(int mat[][]) {
        int startRow = 0;
        int endRow = mat.length - 1;
        int startCol = 0;
        int endCol = mat[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(mat[startRow][j] + " ");// startrow is fixed
            }
            System.out.println();
            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(mat[i][endCol] + " ");// endcol is fixed
            }
            System.out.println();
            /// bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow)
                    break;
                System.out.print(mat[endRow][j] + " ");// endRow is fixed
            }
            System.out.println();
            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol)
                    break;
                System.out.print(mat[i][startCol] + " ");// startCol is fixed
            }
            System.out.println();
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 } };
        spirl(mat);
    }
}
