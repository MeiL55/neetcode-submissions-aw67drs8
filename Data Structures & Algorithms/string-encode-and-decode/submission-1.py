class Solution:
    def encode(self, strs: List[str]) -> str:
        res = ''
        if not strs:
            return res
        for s in strs:
            res += str(len(s)) + '#' + s
        return res
    def decode(self, s: str) -> List[str]:
        #kind of like a two pointer where i is the pointer for word
        #j is the pointer for each character in each word
        #[apple, egg, banana] - > 5#apple3#egg6#banana
        res = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != '#':
                j += 1
            length = int(s[i:j])
            i = j + 1
            j = i + length
            spart = s[i:j]
            res.append(spart)
            i = j #progress to the next one
        return res
            

