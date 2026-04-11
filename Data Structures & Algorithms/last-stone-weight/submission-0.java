class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //minheap default
        for (int st : stones) {
            pq.add(-st);
        }
        System.out.println(pq);
        while (pq.size() > 1) {
            //while there is something
            int x = -pq.poll();
            int y = -pq.poll();
            int dif = y - x;
            System.out.println(dif); 
            System.out.println(pq);
            if (dif < 0) {
                pq.add(dif);
            }
        }
        return pq.isEmpty() ? 0 : -pq.peek();
    }
}
