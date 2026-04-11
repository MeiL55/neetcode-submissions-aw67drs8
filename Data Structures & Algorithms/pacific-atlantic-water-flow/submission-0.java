class Solution {
    private int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int R = heights.length;
        int C = heights[0].length;
        boolean[][] pac = new boolean[R][C];
        boolean[][] atl = new boolean[R][C];
        for (int c = 0; c < C; c++) {
            dfs(0, c, pac, heights);
            dfs(R-1, c, atl, heights);
        }
        for (int r = 0; r < R; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, C-1, atl, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true; //write to pac and atl if theres a path
        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
