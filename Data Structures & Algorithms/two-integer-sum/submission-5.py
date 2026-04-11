class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = []
        if (not nums):
            return res
        freq = {}
        for i, n in enumerate(nums):
            dif = target - n
            if dif in freq:
                return [freq[dif], i]
            freq[n] = i