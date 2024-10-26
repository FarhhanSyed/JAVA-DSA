//Given a "2xn" board/floor and tile size "2x1",count the number of ways to tile the given board using "2x1" tiles
//Time-Complexity-O(2^n)
public class tilingProblem {
    public static int tile(int n)// 2xn(floor size)
    {
        // base-case
        if (n == 0 || n == 1) {
            return 1;
        }

        // vertical-choice
        int vertical = tile(n - 1);

        // horizontal-choice
        int horizontal = tile(n - 2);

        return vertical + horizontal;
    }

    public static void main(String agrs[]) {
        System.out.println(tile(4));
    }
}