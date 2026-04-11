class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(text1, text2, 0, 0, memo);
    }
    private int dfs(String text1, String text2, int r, int c, int[][] memo) {
        //base case
        if (r == text1.length() || c == text2.length()) { //oob
            return 0;
        }
        if (memo[r][c] != -1) {
            return memo[r][c];
        }
        if (text1.charAt(r) == text2.charAt(c)) {
            memo[r][c] = 1 + dfs(text1, text2, r + 1, c + 1, memo);
        } else {
            memo[r][c] = Math.max(dfs(text1, text2, r + 1, c, memo), dfs(text1, text2, r, c + 1, memo));
        }
        return memo[r][c];
    }
}
