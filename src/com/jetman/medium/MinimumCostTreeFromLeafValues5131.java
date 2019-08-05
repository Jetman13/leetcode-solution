package src.com.jetman.medium;

/**
 * @description: https://leetcode-cn.com/contest/weekly-contest-146/problems/minimum-cost-tree-from-leaf-values/
 * @author: Jetman
 * @create: 2019-07-21 14:49
 **/
public class MinimumCostTreeFromLeafValues5131 {

    int[][] dp;
    int[] array;
    public int mctFromLeafValues(int[] arr) {
        dp = new int[arr.length+2][arr.length+2];
        array = arr;
        return work(0,arr.length-1);
    }

    private int work(int l, int r) {
        if (dp[l][r] != 0) return dp[l][r];
        if (l == r) return 0;
        if (l+1 == r) return dp[l][r] = array[l]*array[r];

        dp[l][r] = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            dp[l][r] = Math.min(dp[l][r],work(l,i) + work(i+1,r) + rangeMax(l,i)*rangeMax(i+1,r));
        }
        return dp[l][r];
    }

    private int rangeMax(int i, int r) {
        int max = array[i];
        for (int j = i+1; j <= r ; j++) {
            if (max < array[j]) max = array[j];
        }
        return max;
    }
}
