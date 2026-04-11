class Solution {
    public int maxSubArray(int[] nums) {
        //if computed sum is 0, then we dont need it
        int maxSub = nums[0];
        int currSum = 0;
        for (int n : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += n;
            maxSub = Math.max(maxSub, currSum);
        }
        return maxSub;
    }
}
