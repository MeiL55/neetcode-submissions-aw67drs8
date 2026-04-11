class Solution {
    public int maxArea(int[] heights) {
        //two pointer, find max area
        //(j - i) * min(h[i], h[j])
        //j > i
        //only move the smallest pointer
        int l = 0;
        int r = heights.length - 1;
        int max = 0;
        while (l < r) {
            int size = (r - l) * Math.min(heights[l], heights[r]);
            max = Math.max(size, max);
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
