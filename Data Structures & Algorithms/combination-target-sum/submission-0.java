class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), target, res);
        return res;
    }
    private void helper(int[] nums, int start, ArrayList<Integer> path, int remain, List<List<Integer>> res) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
           res.add(new ArrayList<>(path));
           return;    
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i, path, remain - nums[i], res);
            path.remove(path.size()-1);
        }
    }
}
