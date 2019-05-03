package src.com.jetman.medium;

import java.util.stream.IntStream;

/**
 * @program: za-graphene-anan
 * @description: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author: za-zhangmin
 * @create: 2019-04-10 21:30
 **/
public class LongestPalindromicSubstring5 {
    int[][] dp = new int[1003][1003];
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) return "";


        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dfs(s,i,j) > 0 && (j-i+1) > max) {
                    max = j-i+1;
                    left = i;
                    right = j;
                }
            }
        }


        return s.substring(left,right+1);

    }

    private int dfs(String s,int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = -1;
        if (i == j) {
            ans = 1;
        } else if (i == j-1) {
            if (s.charAt(i) == s.charAt(j)) {
                ans = 1;
            }
        } else {
            if (dfs(s,i+1,j-1) > 0 && s.charAt(i) == s.charAt(j)) {
                ans = 1;
            }
        }
        dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.printf(""+new LongestPalindromicSubstring5().longestPalindrome("babad"));
    }
}
