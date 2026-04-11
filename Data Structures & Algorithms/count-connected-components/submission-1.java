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
                dfs(node, -1, visited, adj);
            }
        }
        return num;
    }
    private void dfs(int node, int parent, Set<Integer> visited, List<List<Integer>> adj) {
        visited.add(node);
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (!visited.contains(nei)) {
                dfs(nei, node, visited, adj);
            }
        }
    }
}
