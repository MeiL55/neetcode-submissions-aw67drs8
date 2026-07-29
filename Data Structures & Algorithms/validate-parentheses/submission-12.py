class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mp = { ")" : "(", "]" : "[", "}" : "{" }
        for c in s:
            if c not in mp:
                stack.append(c)
            else:
                if stack and stack[-1] == mp.get(c):
                    stack.pop()
                else:
                    return False
        return len(stack) == 0