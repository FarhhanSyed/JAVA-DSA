//Time Complexity:O(n)
import java.util.*;
public class diagnol_sum {
    public static void diagnolS(int mat[][]) {
        int sum = 0;
        // for (int i = 0; i <mat.length; i++) {
        // for (int j = 0; j < mat.length; j++) {
        // if (i == j) {
        // sum+= (mat[i][j]);
        // }
        // if ((i + j) == n ) {
        // sum += mat[i][j];
        // }
        // }
        // }
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];

            if (i != mat.length - 1 - i) {
                sum += mat[i][mat.length - 1 - i];
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        diagnolS(mat);
    }
}
