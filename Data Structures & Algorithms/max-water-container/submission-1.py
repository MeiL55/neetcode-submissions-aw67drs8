class Solution:
    def maxArea(self, heights: List[int]) -> int:
        maxR = 0
        l = 0
        n = len(heights)
        r = n - 1
        while l < r:
            R = min(heights[l], heights[r]) * (r - l)
            maxR = max(maxR, R)
            if (heights[l] < heights[r]):
                l += 1
            else:
                r -= 1
        return maxR
