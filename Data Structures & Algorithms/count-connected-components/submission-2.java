class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int num = 0;
        for (int node = 0; node < n; node++) {
            if (!visited.contains(node)) {
                num++;
                bfs(node, visited, adj);
            }
        }
        return num;
    }
    private void bfs(int node, Set<Integer> visited, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited.add(node);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nei : adj.get(curr)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    q.offer(nei);
                }
            }
        }
    }
}
