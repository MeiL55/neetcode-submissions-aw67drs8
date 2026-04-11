class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l+r)/2;
            //if nums[m] > target, since mid has to be with l or r, then check:
            //- nums[m] < nums[r] - r and m are in the same segment, then if m is still greater than the target, we search left
            //if nums[m] < target
            //- nums[m] > nums[l] - l and m are in the same segment, then we can only search right
            //if nums[m] = target - return m
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] <= nums[r]) {
                if (nums[m] <= target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[l] <= target && target <= nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
