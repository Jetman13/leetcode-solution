package src.com.jetman.contest;

import java.util.*;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionA {

    public int movesToMakeZigzag(int[] nums) {

        if (nums.length == 1) return 0;

        int ans = 0;
        int len = nums.length;

        for (int i = 1; i < len; i+=2) {
            ans += cal(nums,i);
        }

        int ans1 = 0;
        for (int i = 0; i < len; i+=2) {
            ans1 += cal(nums,i);
        }
        return Math.min(ans,ans1);
    }

    private int cal(int[] nums, int i) {
        int l = i-1;
        int r = i+1;
        int k = Integer.MAX_VALUE;
        if (l >= 0 && nums[i] > nums[l]) k = nums[i] - nums[l] + 1;
        if (r < nums.length && nums[i] > nums[r]) k = Math.min(nums[i] - nums[r] + 1,k);
        return k;
    }


    public static void main(String[] args) {
        int[] a = {0,2,6,2,7,5};
//        new SolutionA().duplicateZeros(a);
//        System.out.println(new SolutionA().defangIPaddr("1.1.1.1"));



    }

}
