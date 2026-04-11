class Solution {
    public int removeDuplicates(int[] nums) {
        //[1, 2, 2, 2, 3, 4, 4]
        //[1, 2, 3, 2, 3, 4, 4]
        //[1, 2, 3, 4, 3, 4, 4]
        int left = 1; //always keeps track of the first
        int right = 1;//go to the next first unique
        int n = nums.length;
        while (right < n) {
            if (nums[right] != nums[right-1]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}