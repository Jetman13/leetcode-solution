package src.com.jetman.medium;

/**
 * @program: za-graphene-anan
 * @description: Integer Break 343
 * @author: za-zhangmin
 * @create: 2019-03-30 14:42
 *
 * https://leetcode.com/problems/integer-break/
 *  dp[n] = max(dp[n-2] * dp[2],dp[n-3] * dp[3]......)
 **/
public class IntegerBreak343 {

    private int[] dp = new int[60];

    public int integerBreak(int n) {

        if (n == 2) return 1;
        if (n == 3) return 2;

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;

        return dfs(n);

    }

    private int dfs(int n) {
        if (dp[n] != 0) return dp[n];

        dp[n] = dfs(n-1);
        for (int i = 2; i < n - 2; i++) {
            dp[n] = Math.max(dp[n],dfs(n-i) * dfs(i));

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.printf("" + new IntegerBreak343().integerBreak(10));
    }
}
