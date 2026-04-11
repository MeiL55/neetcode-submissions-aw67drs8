class Solution {
    public int characterReplacement(String s, int k) {
        //replace with the most frequent character
        // use a hashmap
        // brute force: all substrings, give a helper function that discerns whether the string only contains one character
        // edit k and see which is the longest
        //sliding window: we increment window, and shrinks it when the edit distance is greater than k
        int n = s.length();
        int start = 0;
        int max = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //int size = k;
        while (i < n) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
            //System.out.println(getMostFreq(map));
            int size = i - start + 1;
            int freq = getMostFreq(map);
            if (size - freq > k) {
                char left = s.charAt(start);
                map.put(left, map.get(left)-1);
                start++; //shrink by one
                size++;
            }
            max = Math.max(max, i - start + 1);
            i++;
        }
        //System.out.println(start);
        return max;
    }
    private int getMostFreq(HashMap<Character, Integer> map) {
        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }
        return max;
    }

}
