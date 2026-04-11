class Solution {
    public int findMin(int[] nums) {
        //n times - normal, 1 time - originally the 1st on top
        //i times - originally ith on top
        //log n - binary search
        int l = 0;
        int r = nums.length - 1;
        //min: the first element in the right sub, increasing array
        //taking a hint: l, mid, r, at least two are in the same subarray
        //taking another hint: check whether l,mid/mid,r are a sorted array, if it is not, then res is in the other array.
        //[3,4,5,6,1,2]
        //l    m      r
        //][6,1,2]
        //  l m r
        //
        //int min = 0;//no 0 assumed
        int min = nums[0];
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }
            min = Math.min(nums[m], min);
            if (nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return min;
    }
}
