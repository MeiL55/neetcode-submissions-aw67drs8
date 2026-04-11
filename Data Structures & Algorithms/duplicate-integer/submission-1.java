class Solution {
    public boolean hasDuplicate(int[] nums) {
        //hashmap, num -> count, if one num existed in the array, then return true, at last return false.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //System.out.println(map);
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }
}