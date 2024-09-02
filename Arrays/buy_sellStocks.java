class buy_sellStocks {
    public static int buy_sell(int prices[]) {
        int maxProfit = 0;
        int sellPrice;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            sellPrice = prices[i];
            if (buyPrice < sellPrice)// profit
            {
                int profit = sellPrice - buyPrice;// today's profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = sellPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(buy_sell(prices));
    }
}
