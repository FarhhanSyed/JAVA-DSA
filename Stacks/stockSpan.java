//The stock span of a stock's price on a given day is the maximum number of consecutive days
//(including the current day) for which the stock price was less than or equal to the current
//day's price.

//Time Complexity-O(n)
//Space Complexity-O(n)
import java.util.*;

public class stackSpan {
    public static void span(int stocks[]) {
        int[] span = new int[stocks.length];
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!st.isEmpty() && currPrice >= stocks[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(span));
    }

    public static void main(String[] args) {
        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        span(stocks);

    }
}
