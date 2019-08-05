package src.com.jetman.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description: https://leetcode-cn.com/problems/combination-sum/
 * @author: Jetman
 * @create: 2019-07-17 22:25
 **/
public class CombinationSum39 {

    int[] nums;
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int len;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;
        len = nums.length;
        if (len == 0) return ans;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        work(0,list,target);
        return ans;
    }

    void work(int index,List<Integer> list,int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return ;
        }
        if (target < 0) return ;

        list.add(-1);
        for (int i = index;i<len;i++) {
            if (target >= nums[i]) {
                list.set(list.size()-1,nums[i]);
                work(i,list,target-nums[i]);
            }
        }
        list.remove(list.size()-1);
    }


    public static void main(String[] args) {
        int[] n = {2,3,6,7};
        int t = 7;
        System.out.println(new CombinationSum39().combinationSum(n,t));
    }

}
