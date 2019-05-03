package src.com.jetman.easy;

import java.util.Arrays;

/**
 * @program: za-graphene-anan
 * @description: https://leetcode-cn.com/problems/house-robber/
 * @author: za-zhangmin
 * @create: 2019-04-06 10:32
 **/
public class HouseRobber198 {

    int length = 0;

    public int rob(int[] nums) {


        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        length = nums.length;
        int[] dp = new int[length +2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i],dp[i-1]);
            dp[i] = Math.max(dp[i],dp[i-2] + nums[i]);
        }

        return Math.max(dp[length-1],dp[length-2]);

    }

    public static void main(String[] args) {
        int[] nums = {1,2};

        System.out.printf("" + new HouseRobber198().rob(nums));
    }

}
