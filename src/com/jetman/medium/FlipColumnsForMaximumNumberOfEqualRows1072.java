package src.com.jetman.medium;

/**
 * @program:
 * @description: https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 * @author: Jetman
 * @create: 2019-06-08 12:55
 **/
public class FlipColumnsForMaximumNumberOfEqualRows1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        boolean[] flag = new boolean[matrix.length];
        int len = matrix.length;
        int ans = 1;
        for (int i = 0; i < len; i++) {
            if (flag[i]) continue;

            flag[i] = true;
            int num = 1;
            for (int j = 0; j < len; j++) {
                if (!flag[j] && compare(matrix[i],matrix[j])) {
                    flag[j] = true;
                    num++;
                }
            }

            ans = Math.max(ans,num);

        }

        return ans;

    }

    private boolean compare(int[] s,int[] t) {
        int len = s.length;
        int i = 0;
        for (i = 0; i < len; i++) {
            if (s[i] != t[i]) break;
        }

        if (i == len) return true;

        for (i = 0; i < len; i++) {
            if (s[i] == t[i]) break;
        }
        return i == len;
    }
}
