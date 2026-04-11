class Solution {
    public void sortColors(int[] nums) {
        //get to know the length of bucket - 3
        int[] buckets = new int[3];
        for (int num : nums) {
            buckets[num]++;
        }
        int write = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                nums[write] = i;
                write++;
            }
        }
    }
}