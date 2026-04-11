class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //edge case: no clear path: start or end is blocked
        int N = grid.length;
        if (grid[0][0] == 1 || grid[N-1][N-1] == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};
        q.offer(new int[] {0, 0, 1}); //make sure the loop runs
        int length = 0;
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            length = cell[2];
            if (r == N - 1 && c == N - 1) {
                return length;
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if ((nr >= 0 && nr < N) && (nc >= 0 && nc < N) && grid[nr][nc] == 0) {
                    q.offer(new int[]{nr, nc, length+1});
                    grid[nr][nc] = 1;
                }
            }
        }
        return -1;
    }
}