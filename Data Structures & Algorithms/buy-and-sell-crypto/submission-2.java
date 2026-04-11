class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int length = 0; 
            while ((i + length < prices.length) && (prices[i] <= prices[i + length])) {
                if (prices[i+length]-prices[i] > max) {
                    max = Math.max(max, prices[i+length]-prices[i]);
                }
                length++;
            }
        }
        System.out.println(max);
        return max;
    }
}
