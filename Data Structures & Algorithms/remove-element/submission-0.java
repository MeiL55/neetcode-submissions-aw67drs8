class Solution {
    public int removeElement(int[] nums, int val) {
        //[11234], [11234], [12234],[12334],[12344]
        int n = nums.length;
        int write = 0; //write index
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[write] = nums[i];
                write++;
            }
        }
        return write;
    }
}