class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        n = len(nums)
        nset = set(nums)
        longest = 0
        for num in nums:
            if (num - 1) not in nset:
                length = 1
                while (num + length) in nset:
                    #this works bc count small to big
                    length +=1
                longest = max(length, longest)
        return longest
                
            



        
        