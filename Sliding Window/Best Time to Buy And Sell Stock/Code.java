public static void main(String[] args) 
{
    Solution sol = new Solution();
    int[] prices = {10, 1, 5, 6, 7, 1};
    int result = sol.maxProfit(prices);
    System.out.println("FINAL RESULT = " + result);
}

public class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxP;
    }
}

Time & Space Complexity
• Time complexity: On)
• Space complexity: 0(1)
