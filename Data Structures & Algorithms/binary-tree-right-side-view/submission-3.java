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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                //System.out.println(curr.val);
                if (curr.right != null) {
                    queue.offer(curr.right);
                } 
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (i == 0) {
                    res.add(curr.val);
                }
                level++;
            }
        }
        return res;
    }
}
