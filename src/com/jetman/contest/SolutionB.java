package src.com.jetman.contest;



import src.com.jetman.base.TreeNode;

import java.util.*;

/**
 * @description: Solution
 * @author: Jetman
 * @create: 2019-04-04 20:59
 **/
public class SolutionB {

    int[] nums;
    TreeNode xNode;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        nums = new int[n+1];
        if (n == 1) return false;

        nums[root.val] = work(root,x);

        int numL = xNode.left != null ? nums[xNode.left.val] : 0;
        int numR = xNode.right != null ? nums[xNode.right.val] : 0;
        int numP = n - numL - numR - 1;
        int mid = n/2;
        if (numL > mid || numR > mid || numP > mid) return true;
        return false;

    }

    private int work(TreeNode root, int x) {
        if (root == null) return 0;

        if (root.val == x) {
            xNode = root;
        }

        int num = work(root.left,x);
        num+=work(root.right,x);
        nums[root.val] = num + 1;
        return nums[root.val];
    }


    public static void main(String[] args) {
        long sta = System.currentTimeMillis();
        int[] a = {5,4,3,2,1};
        int[] b = {1,3,3,3,2};
//        System.out.println(""+new SolutionB().largestValsFromLabels(a,b,3,2));
        System.out.println("all = "+(System.currentTimeMillis()-sta));

    }

}
