package src.com.jetman.medium;


import javafx.util.Pair;

/**
 * @program: za-graphene-anan
 * @description: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * @author: za-zhangmin
 * @create: 2019-03-31 20:21
 **/
public class FlattenBinaryTreeToLinkedList114 {


    public void flatten(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) return;


        Pair<TreeNode, TreeNode> newRoot = dfs(root);
        root.left = null;
        root.right = newRoot.getKey().right;


    }

    private Pair<TreeNode,TreeNode> dfs(TreeNode root) {

//        System.out.printf(" " + root.val);
        TreeNode startNode = new TreeNode(root.val);
        TreeNode endNode = startNode;

        if (root.left == null && root.right == null) return new Pair<TreeNode, TreeNode>(startNode,endNode);


        Pair<TreeNode,TreeNode> left = null;
        Pair<TreeNode,TreeNode> right = null;
        if (root.left != null) {
            left = dfs(root.left);
        }

        if (root.right != null) {
            right = dfs(root.right);
        }



        if (left != null) {
            endNode.right = left.getKey();
            endNode = left.getValue();
        }

        if (right != null) {
            endNode.right = right.getKey();
            endNode = right.getValue();
        }

        return new Pair<TreeNode, TreeNode>(startNode,endNode);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        new FlattenBinaryTreeToLinkedList114().flatten(node1);

        while (node1 != null) {
            System.out.printf(" " + node1.val);
            node1 = node1.right;
        }


    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
