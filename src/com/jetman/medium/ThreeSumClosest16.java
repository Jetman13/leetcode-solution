package src.com.jetman.medium;

import java.util.*;

/**
 * @program: za-graphene-anan
 * @description: https://leetcode-cn.com/problems/3sum-closest/
 * @author: za-zhangmin
 * @create: 2019-05-25 14:50
 **/
public class ThreeSumClosest16 {

    public int threeSumClosest(int[] nums,int target) {

        if (nums.length <= 3) return Arrays.stream(nums).sum();

        Arrays.sort(nums);
        int length = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i=0;i<length;i++) {
            for (int j=i+1;j<length;j++) {
                int sum = target-nums[i]-nums[j];
                int index = Arrays.binarySearch(nums,j+1,length,sum);
                if (index >= 0) return target;
                index = -(index+1) - 1;
                int p = Math.abs(ans-target);
                for (int k = index; k < index+3; k++) {
                    if (k > j && k<length && (Math.abs(nums[i]+nums[j]+nums[k] - target) < p)) {
                        ans = (nums[i]+nums[j]+nums[k]);
                        p = Math.abs(ans-target);
                    }
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,2,5,10,11};
        System.out.println("" + new ThreeSumClosest16().threeSumClosest(a,12));
    }

}
