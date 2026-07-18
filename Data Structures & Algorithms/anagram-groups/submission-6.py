class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)
        if (len(strs) == 0):
            return res
        for str in strs:
            count = [0] * 26
            for char in str:
                count[ord(char)-ord('a')] += 1
            key = tuple(count)
            res[key].append(str)
        return list(res.values())
        


            

        