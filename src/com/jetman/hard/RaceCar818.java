package src.com.jetman.hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/race-car/
 */
public class RaceCar818
{


    private int[] dp = new int[30000];
    private int[] pow = new int[30];
    private final int POW_INDEX = 14;


    public int racecar(int target) {
        Arrays.fill(dp,Integer.MAX_VALUE);
        initPow();
        initDp();
//        for (int i = 0; i < 50; i++) {
//            System.out.printf(" a[" + i +"]=" + dp[i] + " ");
//        }
        return dfs(target);

    }

    private int dfs(int target) {
        if (dp[target] != Integer.MAX_VALUE) return dp[target];

        int n = (int)(Math.log(target)/Math.log(2)) + 1;
        dp[target] = dfs(pow[n] - 1 - target) + n + 1;
        for (int i = 0; i < n; i++) {
            dp[target] = Math.min(dp[target],dfs(target - pow[n-1] + pow[i]) + n + i );

        }
        return dp[target];
    }

    private void initDp() {
        dp[1] = 1;
        for (int i = 1 ; i < POW_INDEX ; i++) {
            int left = pow[i] - 1;
            int right = pow[i+1] - 1;
            dp[left] = i;
            dp[right] = i + 1;
            int index = 1;
            int row = left + pow[index] - 1;
            while (row < right) {
                dp[row] = Math.min(dp[left] + 2 + index,dp[row]);
                index++;
                row = left + pow[index] - 1;
            }

            index = 1;
            row = right - pow[index] + 1;
            while (row > left) {
                dp[row] = Math.min(dp[right] + 1 + index,dp[row]);
                index++;
                row = right - pow[index] + 1;

            }
        }

    }

    private void initPow() {
        pow[0] = 1;
        for (int i = 1 ; i <= POW_INDEX ; i++) {
            pow[i] = pow[i-1] * 2;
        }
    }


    public static void main( String[] args )
    {
        RaceCar818 solution = new RaceCar818();
        System.out.println();
        System.out.println( solution.racecar(64));
    }
}
