package src.com.jetman.medium;

/**
 * @description: https://leetcode-cn.com/problems/stone-game-ii/
 * @author: Jetman
 * @create: 2019-08-01 23:08
 **/
public class StoneGameII1140 {

    int[][] dp;
    int[] sum;
    int len;
    public int stoneGameII(int[] piles) {
        len = piles.length;
        dp = new int[len+1][len+1];
        sum = new int[len+1];

        for (int i=0;i<piles.length;i++) {
            sum[i+1] = sum[i] + piles[i];
        }

        return work(1,1);

    }

    private int work(int n,int m) {
        if (n > len) return 0;
        if (dp[n][m] != 0) return dp[n][m];
        if (n == len) return dp[n][m] = (sum[len] - sum[len-1]);

        int ans = 0;
        for (int i=1;i<=m*2;i++) {
            ans = Math.max(ans,sum[len] - sum[n-1] - work(n+i,Math.max(m,i)));
        }
        return dp[n][m] = ans;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        StoneGameII1140 s = new StoneGameII1140();
        System.out.println(s.stoneGameII(a));
        System.out.println("");
    }
}
