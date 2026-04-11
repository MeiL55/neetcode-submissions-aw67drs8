class Solution {
    public int removeDuplicates(int[] nums) {
        //[1, 2, 2, 2, 3, 4, 4]
        //[1, 2, 3, 2, 3, 4, 4]
        //[1, 2, 3, 4, 3, 4, 4]
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            nums[left] = nums[right];
            while (right < n && nums[left] == nums[right]) {
                right++;
            }
            left++;
        }
        return left;
    }
}