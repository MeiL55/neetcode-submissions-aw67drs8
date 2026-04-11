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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (helper(root, subRoot)) {
            return true;
        }
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
    private boolean helper(TreeNode curr, TreeNode comp) {
        if (curr == null && comp == null) {
            return true;
        }
        if (curr != null && comp != null && curr.val == comp.val) {
            return helper(curr.left, comp.left) && helper(curr.right, comp.right);
        }
        return false;
    }
}
