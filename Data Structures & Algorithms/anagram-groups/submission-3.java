class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            //List<String> list = new ArrayList<>();
            int count[] = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
