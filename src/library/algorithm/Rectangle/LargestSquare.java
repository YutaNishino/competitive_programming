package library.algorithm.Rectangle;

public class LargestSquare {
    static int largestSquare(int[][] board, int blocked) {
        int h = board.length;
        int w = board[0].length;
        int[][] dp = new int[h + 1][w + 1];
        int maxWidth = 0;
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (board[i - 1][j - 1] == blocked) {
                    continue;
                }
                int temp = dp[i - 1][j - 1] + 1;
                temp = Math.min(temp, dp[i - 1][j] + 1);
                temp = Math.min(temp, dp[i][j - 1] + 1);
                dp[i][j] = temp;
                maxWidth = Math.max(maxWidth, dp[i][j]);
            }
        }
        return maxWidth * maxWidth;
    }
}
