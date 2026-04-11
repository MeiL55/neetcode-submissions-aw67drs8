class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //pointer needs to reach n-1
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= n-1) {
                n = i + 1;
            }
        }
        return n == 1;
    }
}
