class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prod = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num != 0) {
                prod *= num;
            } else {
                zeroCount++;
            }
        }
        if (zeroCount > 1) {
            return new int[nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                if (nums[i] == 0) {
                    res[i] = prod;
                } else {
                    res[i] = 0;
                }
            } else {
                res[i] = prod / nums[i];
            }

        }
        return res;
    }
}  
