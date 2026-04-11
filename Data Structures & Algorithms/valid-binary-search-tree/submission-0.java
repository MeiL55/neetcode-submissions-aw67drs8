/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode curr, long min, long max) {
        if (curr == null) {
            return true;
        }
        if (curr.val <= min || curr.val >= max) {
            return false;
        }
        return (helper(curr.left, min, curr.val) && helper(curr.right, curr.val, max));
    }
}
