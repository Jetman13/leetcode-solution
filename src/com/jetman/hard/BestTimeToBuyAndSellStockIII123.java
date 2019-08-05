package src.com.jetman.hard;

/**
 * @description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @author: Jetman
 * @create: 2019-03-31 00:28
 **/
public class BestTimeToBuyAndSellStockIII123 {

    public int maxProfit(int[] prices) {
        
        int length = prices.length;
        
        if (length < 2) return 0;

        int[] dpLeft = new int[1000002];
        int[] dpRight = new int[1000002];
        
        //左边第一个到n的一次交易最大收益
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            dpLeft[i] = Math.max(dpLeft[i-1],prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        
        //n到右边最后一个的一次最大交易收益
        int max = prices[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            dpRight[i] = Math.max(dpRight[i+1],max - prices[i]);
            max = Math.max(max,prices[i]);
        }

        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans = Math.max(ans,dpLeft[i] + dpRight[i]);
            
        }
        
        return ans;

    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.printf("" + new BestTimeToBuyAndSellStockIII123().maxProfit(prices));
    }

}
