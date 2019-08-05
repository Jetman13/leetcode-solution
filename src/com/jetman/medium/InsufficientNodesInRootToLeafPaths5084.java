package src.com.jetman.medium;

import src.com.jetman.base.TreeNode;

/**
 * @program:
 * @description: https://leetcode-cn.com/contest/weekly-contest-140/problems/insufficient-nodes-in-root-to-leaf-paths/
 * @author: Jetman
 * @create: 2019-06-09 14:04
 **/
public class InsufficientNodesInRootToLeafPaths5084 {

    private int limit;
    public TreeNode sufficientSubset(TreeNode root, int l) {
        limit = l;
        boolean f = go(root,0);
        return f?null:root;
    }

    private boolean go(TreeNode root,int sum) {
        if (root == null) return true;
        sum += root.val;
        if (root.left == null && root.right == null) {
            return (sum < limit);
        }
        boolean l = go(root.left,sum);
        boolean r = go(root.right,sum);
        if (l) {
            root.left = null;
        }
        if (r) {
            root.right = null;
        }

        return l&&r;
    }
}
