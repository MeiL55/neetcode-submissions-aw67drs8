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
    private int preIdx = 0;
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = preorder[preIdx++];
        TreeNode root = new TreeNode(rootValue);
        int mid = map.get(rootValue);
        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder, mid + 1, right);
        return root;
    }
}
