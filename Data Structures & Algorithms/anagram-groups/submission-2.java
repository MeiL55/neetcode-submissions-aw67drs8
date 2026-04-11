class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            int[] lookup = new int[26];
            for (char c: s.toCharArray()) {
                lookup[c-'a']++;
            }
            String key = Arrays.toString(lookup);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
