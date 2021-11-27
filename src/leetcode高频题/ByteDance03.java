package leetcode高频题;

/**
 * 字节算法面试
 * 二叉树最短路径
 */
public class ByteDance03 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * 二叉树的最短路径，递归写法
     * @param root TreeNode类
     * @return int整型
     */
    public int run(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        int left = run(root.left);
        int right = run(root.right);
        if (left * right > 0) {
            return (Math.min(left, right)) + 1;
        } else {
            return (Math.max(left, right)) + 1;
        }
    }
}

