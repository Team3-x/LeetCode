import javax.swing.tree.TreeNode;

/**
 * @author Team3
 * @date 2020/11/9 21:23
 *
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (treeHeight(root) != -1);
    }

    public int treeHeight(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = treeHeight(root.left);
        int rightDepth = treeHeight(root.right);
        if (leftDepth == -1 || rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) return -1;
        return (Math.max(leftDepth, rightDepth)+1);
    }
}
