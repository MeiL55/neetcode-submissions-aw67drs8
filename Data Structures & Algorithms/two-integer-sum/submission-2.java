class Solution {
    public int[] twoSum(int[] nums, int target) {
        //hashmap, num -> index, if target - new num traversed is in map, save in result arr
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
