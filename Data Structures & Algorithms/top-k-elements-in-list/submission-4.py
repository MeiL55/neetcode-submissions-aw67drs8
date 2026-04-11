class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #probably need to use slice
        dict = defaultdict(int)
        for n in nums:
            dict[n] = 1 + dict.get(n, 0)
        sorted_items = sorted(dict.items(), key=lambda x: x[1], reverse=True)
        res = []
        count = 0
        for item in sorted_items:
            if count == k:
                return res
            res.append(item[0])
            count += 1
        return res 
