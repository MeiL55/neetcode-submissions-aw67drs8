class Solution {
    public int orangesRotting(int[][] grid) {
        //visited: 2, not visited: 1, shortest path: bfs
        int R = grid.length;
        int C = grid[0].length;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        //int time = 0;
        for(int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c, 1});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        System.out.println("Fresh:"+fresh);
        int t = 0;
        while (fresh > 0 && !q.isEmpty()) {
            int[] wow = q.poll();
            int r = wow[0];
            int c = wow[1];
            t = wow[2];
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if ((nr >=0 && nr < R) && (nc >=0 && nc < C) && (grid[nr][nc] == 1)) {
                    q.offer(new int[]{nr, nc, t + 1});
                    fresh--;
                    grid[nr][nc] = 2;
                }
            }
        }
        return fresh == 0 ? t : -1;
    }
}
