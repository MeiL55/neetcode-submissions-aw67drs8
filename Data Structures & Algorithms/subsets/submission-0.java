class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void helper(int[] nums, int start, ArrayList<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i+1, path, res);
            path.remove(path.size()-1);
        }
    }
}
