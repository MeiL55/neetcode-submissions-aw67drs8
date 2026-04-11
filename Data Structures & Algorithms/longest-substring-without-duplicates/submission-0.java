class Solution {
    public int lengthOfLongestSubstring(String s) {
        //brute force: check all substrings, find the one with no duplicate characters, longest
        //like having a menthod for checking duplicates
        //finding all substrings: O(n^2), checking duplicates:O(n), so O(n^3)
        //optimized1: O(1) in checking duplicates - using HashMap
        //optimized2: sliding window. As we find a duplicate value in the window, we shrink it (and update hashset)
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        int l = 0;
        int r = 0; //i is the right pointer
        for (int i = 0; i < n; i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(i));
            max = Math.max(max, i - l + 1);

        }
        return max;
    }
}
