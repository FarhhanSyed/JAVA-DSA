import java.util.*;

public class staircaseSearch {
    public static boolean search(int mat[][], int key) {
        int row = 0;
        int col = mat[0].length - 1;
        while (row < mat.length && col >= 0) {
            if (mat[row][col] == key) {
                System.out.println("key found at: " + "(" + row + "," + col + ")");
                return true;
            }
            if (key < mat[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        search(arr, 33);
    }
}

// import java.util.*;

// public class searchinsortedMatrix {
//     public static boolean search(int mat[][], int key) {
//         int col=0;
//         int row=mat[0].length-1;
//         while(row>=0 && col<mat.length)
//         {
//             if(mat[row][col]==key)
//             {
//                 System.out.println("("+row+","+col+")");
//                 return true;
//             }
//             else if (key<mat[row][col])
//             {
//                 row--;
//             }
//             else{
//                     col++;
//             }
//         }
//         System.out.println("key not found");
//         return false;
//     }

//     public static void main(String[] args) {
//         int arr[][] = { { 10, 20, 30, 40 },
//                 { 15, 25, 35, 45 },
//                 { 27, 29, 37, 48 },
//                 { 32, 33, 39, 50 } };
//         search(arr, 30);
//     }
// }
