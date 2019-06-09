package src.com.jetman.medium;

import java.util.*;

/**
 * @program: za-graphene-anan
 * @description: https://leetcode-cn.com/problems/3sum
 * @author: za-zhangmin
 * @create: 2019-05-25 14:50
 **/
public class ThreeSum15 {

    private Set<String> flag = new HashSet<String>();
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;

        Arrays.sort(nums);
        int length = nums.length;
        for (int i=0;i<length && nums[i] <= 0;i++) {
            for (int j=i+1;j<length;j++) {
                if (j != i+1 && nums[j] == nums[j-1]) continue;
                int sum = -nums[i]-nums[j];
                if (Arrays.binarySearch(nums,j+1,length,sum)>=0 && !con(nums,i,j)) {
                    ans.add(Arrays.asList(nums[i],nums[j],sum));
                }
            }
        }
        return ans;
    }

    private boolean con(int[] nums, int i, int j) {
        String key = "" + nums[i] + nums[j];
        boolean f = flag.contains(key);
        if (!f) {
            flag.add(key);
        }
        return f;
    }

    public static void main(String[] args) {
        int[] a = {-1,0,1,2,-1,-4,0,0};
        System.out.println("" + new ThreeSum15().threeSum(a));
    }

}
