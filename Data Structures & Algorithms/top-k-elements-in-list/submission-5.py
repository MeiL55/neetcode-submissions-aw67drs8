class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #probably need to use slice
        dict = defaultdict(int)
        for n in nums:
            dict[n] = 1 + dict.get(n, 0)
        heap = []
        for num in dict.keys():
            heapq.heappush(heap, (dict[num], num))
            if len(heap) > k:
                heapq.heappop(heap)
        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        return res
