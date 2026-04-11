class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> cto = new HashMap<>();
        cto.put(')', '(');
        cto.put(']', '[');
        cto.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cto.containsKey(c)) {
                //stack.peek is the closest one
                if (!stack.isEmpty() && stack.peek() == cto.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
