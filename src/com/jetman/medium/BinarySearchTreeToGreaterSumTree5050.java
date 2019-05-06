package src.com.jetman.medium;

import src.com.jetman.base.TreeNode;

/**
 * @program: za-graphene-anan
 * @description:
 * @author: za-zhangmin
 * @create: 2019-05-05 21:26
 **/
public class BinarySearchTreeToGreaterSumTree5050 {

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {

        if (root == null) return new TreeNode(0);

        TreeNode right = bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        TreeNode left = bstToGst(root.left);
        boolean a = Math.abs(34 * 54) == Math.abs(3 * 2);

        return root;

    }
}
