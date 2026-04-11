class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int len = 0;
        //2D dp question
        //base case
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > len) {
                        len = j - i + 1;
                        start = i;
                    }

                } else {
                    dp[i][j] = false;
                    continue;
                }
            }
        }
        return s.substring(start, start+len);
    }
}
