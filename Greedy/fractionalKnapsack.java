import java.util.*;

public class fractionalKnapsack {
    static class Item {
        int val;
        int wt;
        double ratio;

        Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
            this.ratio = (double) val / wt;
        }
    }

    public static double knapsack(int[] values, int[] weights, int W) {
        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(new Item(values[i], weights[i]));
        }
        list.sort((a, b) -> Double.compare(b.ratio, a.ratio));
        double res = 0;
        for (Item item : list) {
            if (W == 0) {
                break;
            }
            if (W > item.wt) {
                res += item.val;
                W -= item.wt;
            } else {
                res += ((double) item.val / item.wt) * W;
                W = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] val = { 10, 20, 30 };
        int[] wt = { 5, 10, 15 };
        int capacity = 100;
        System.out.println(knapsack(val, wt, capacity));
    }
}