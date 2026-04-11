class Solution {
    public int findKthLargest(int[] nums, int k) {
        //create a minheap, maintain a size of k, everytime the size went over k, pop the smallest, so the remaining 2 are the largest one, just return the top
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            add(pq, nums, k, num);
        }
        return pq.peek();
    }
    private void add (PriorityQueue<Integer> pq, int[] nums, int k, int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
    }
}
