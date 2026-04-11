class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //base case - for the whole problem
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        //base case for the dp array
        //dp[i] represents the best amount we can rob for th first i+1 house
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //recursion
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        //return value - from the first n houses
        return dp[n-1];

    }
}
