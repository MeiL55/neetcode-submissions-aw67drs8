class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        int R = grid.length;
        int C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0'; //to prevent re-visiting
        for (int[] dir : dirs) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
