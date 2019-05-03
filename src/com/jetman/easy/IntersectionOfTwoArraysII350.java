package src.com.jetman.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * @author: za-zhangmin
 * @create: 2019-03-30 16:44
 **/
public class IntersectionOfTwoArraysII350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> ansList = new ArrayList<Integer>();

        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            while(index < nums2.length && nums1[i] > nums2[index]) {
                index++;
            }

            if (index < nums2.length && nums1[i] == nums2[index]) {
                ansList.add(nums1[i]);
                index++;
            }
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;

    }


    public static void main(String[] args) {
        int[] num1 = {1,2,2,1,9,5};
        int[] num2 = {2};
        System.out.printf("" + Arrays.toString(new IntersectionOfTwoArraysII350().intersect(num1,num2)));
    }

}
