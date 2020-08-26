package cn.chenhenry.java.game;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution3 {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0) {
            return 0;
        }
        if (rows == 0 || cols == 0) {
            return Math.min(Math.max(rows, cols), threshold);
        }

        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                doIt(threshold, rows, cols, dp, r, c, 3);
            }
        }

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (1 == dp[r][c]) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * @param threshold
     * @param rows
     * @param cols
     * @param dp
     * @param r
     * @param c
     * @param dir 1左 2上 3右 4下
     * @return
     */
    private boolean doIt(int threshold, int rows, int cols,
                         int[][] dp, int r, int c, int dir) {
        if (r < 0 || c < 0 || r == rows || c == cols) {
            return false;
        }

        if (0 != dp[r][c]) {
            return 1 == dp[r][c];
        }

        int score = 0;
        int tmp = r;
        while (tmp > 0) {
            score += tmp % 10;
            tmp = tmp / 10;
        }
        tmp = c;
        while (tmp > 0) {
            score += tmp % 10;
            tmp = tmp / 10;
        }
        if (score > threshold) {
            dp[r][c] = -1;
            return false;
        }

        System.out.println("rows="+rows+",cols="+cols+",r="+r+",c="+c);
        if (((r - 1 >= 0) && (1 == dp[r - 1][c]))
                || ((c - 1 >= 0) && (1 == dp[r][c - 1]))
                || ((r + 1 < rows) && (1 == dp[r + 1][c]))
                || ((c + 1 < cols) && (1 == dp[r][c + 1]))) {
            dp[r][c] = 1;
            return true;
        }

        if (3 != dir && r - 1 >= 0 && 0 == dp[r - 1][c]) {
            doIt(threshold, rows, cols, dp, r-1, c, 1);
        } else if (4 != dir && c - 1 >= 0 && 0 == dp[r][c - 1]) {
            doIt(threshold, rows, cols, dp, r, c-1, 2);
        } else if (1 != dir && r + 1 < rows && 0 == dp[r+1][c]) {
            doIt(threshold, rows, cols, dp, r+1, c, 3);
        } else if (2 != dir && c + 1 < cols && 0 == dp[r][c+1]) {
            doIt(threshold, rows, cols, dp, r, c+1, 4);
        }

        dp[r][c] = -1;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().movingCount(-10, 10, 10));
    }
}
