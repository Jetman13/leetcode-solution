package src.com.jetman.medium;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @program:
 * @description: https://leetcode-cn.com/contest/college/2019-spring/problems/minimize-rounding-error-to-meet-target/
 * @author: Jetman
 * @create: 2019-04-14 21:02
 **/
public class MinimizeRoundingErrorToMeetTarget {

    double[][] dp = new double[501][501];
    public String minimizeError(String[] prices, int target) {
        double[] pri = new double[prices.length];
        int length = 0;
        for (int i = 0 ; i < prices.length ; i++) {
            double a = new BigDecimal(prices[i]).doubleValue();
            int floor = (int)Math.floor(a);
            target -= floor;
            if (a - floor != 0.0) {
                pri[length++] = a - (double)floor;
            }
        }

        if (target < 0 || target >length) return "-1";
        if (length == 0) return "0.000";

        dp[0][1] = 1 - pri[0];
        dp[0][0] = pri[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i-1][0] + pri[i];
            for (int j = 1; j <= i+1; j++) {
                dp[i][j] = Double.MAX_VALUE;
                if (dp[i-1][j-1] != 0.0) {
                    dp[i][j] = Double.min(dp[i][j],dp[i-1][j-1] + 1.0 - pri[i]);
                }
                if (dp[i-1][j] != 0.0) {
                    dp[i][j] = Double.min(dp[i][j],dp[i-1][j] + pri[i]);
                }
            }
        }

        DecimalFormat df3  = new DecimalFormat("##.000");
        if (dp[length-1][target] != 0.0 && dp[length-1][target] != Double.MAX_VALUE) {
            return df3.format(dp[length-1][target]);
        }
        return "-1";

    }

    public static void main(String[] args) {
        String[] pri = {"1.500","2.500","3.500"};
        System.out.printf(""+new MinimizeRoundingErrorToMeetTarget().minimizeError(pri,10));
    }
}
