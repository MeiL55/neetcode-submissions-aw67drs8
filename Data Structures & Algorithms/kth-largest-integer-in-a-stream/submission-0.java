class KthLargest {
    PriorityQueue<Integer> pq;
    //minheap
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        //add to pq and maintain structure and order property
        pq.add(val);
        if (pq.size() > k) {
            //real elements >= k
            pq.poll();
        }
        return pq.peek();
    }
}
