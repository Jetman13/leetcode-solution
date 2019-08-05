package src.com.jetman.medium;

/**
 * @program:
 * @description:
 * @author: Jetman
 * @create: 2019-05-05 22:38
 **/
public class MinimumScoreTriangulationOfPolygon5047 {

    int[][] dp = new int[54][54];
    int[] a = new int[54];
    int length;
    public int minScoreTriangulation(int[] A) {
        length = A.length;
        System.arraycopy(A,0,a,1,A.length);

        return dpL(1,length);
    }

    private int dpL(int start,int end) {
        if (dp[start][end] != 0) return dp[start][end];
        if (end - start < 2) return 0;

        if (end - start == 2) {
            dp[start][end] = a[start] * a[start+1] * a[end];
            return dp[start][end];
        }

        int min = Integer.MAX_VALUE;
        for (int i = start+1; i < end; i++) {
            min = Math.min(min,dpL(start,i) + dpL(i,end) + (a[start]*a[end]*a[i]));
        }
        dp[start][end] = min;
        return dp[start][end];
    }
}
