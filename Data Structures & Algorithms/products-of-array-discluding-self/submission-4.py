class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prod, zero_count = 1, 0
        n = len(nums)
        res = [0] * n
        for num in nums:
            if num != 0:
                prod *= num
            else:
                zero_count += 1
        if zero_count > 1:
            return res
        for i, c in enumerate(nums):
            if zero_count > 0:
                if c == 0:
                    res[i] = prod
                else:
                    res[i] = 0
            else:
                res[i] = prod // c
        return res