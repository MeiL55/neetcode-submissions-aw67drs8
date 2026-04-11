class Solution {
    public boolean isValid(String s) {
        //use stack, use hashmap
        //"([{}])"
        Map<Character, Character> cto = new HashMap<>();
        cto.put(')', '(');
        cto.put(']', '[');
        cto.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (cto.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == cto.get(c)) {
                    stack.pop();
                } else {
                    //no corresponding open
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
