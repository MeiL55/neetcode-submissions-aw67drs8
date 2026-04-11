class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
        for (int[] arr : points) {
            add(pq, k, arr);
        }
        return pq.toArray(new int[pq.size()][]);
    }
    private void add(PriorityQueue<int[]> pq, int k, int[] arr) {
        pq.offer(arr);
        if (pq.size() > k) {
            pq.poll();
        }
    }
    private int distance(int[] p) {
        int x = p[0];
        int y = p[1];
        return x*x + y*y;
    }
}
