//In one step, you can take one card from the beginning or from the end of the row.
//You have to take exactly k cards.
//Time-Complexity-O(k)
public class maxPointsFromCards {
    public static int maxPoints(int[] cardPoints, int k) {
        int max = Integer.MIN_VALUE;
        int lsum = 0;
        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }
        max = lsum;
        int rIdx = cardPoints.length - 1;
        int rsum = 0;
        for (int i = k - 1; i >= 0; i--) {
            lsum = lsum - cardPoints[i];
            rsum += cardPoints[rIdx];
            rIdx--;
            max = Math.max(max, lsum + rsum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        System.out.println(maxPoints(cardPoints, k));
    }
}