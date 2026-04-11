class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        //bucket sort: bucket group by frequency
        List<Integer>[] freq = new List[nums.length + 1];
        //+1 to prevent oob
        //forgot to attach actual empth arr
        for (int i = 0; i < freq.length;i++) {
            freq[i] = new ArrayList<>();
        }
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
