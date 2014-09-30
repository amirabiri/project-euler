package euler.solutions;

import euler.common.BaseSolution;

public class _15 extends BaseSolution {
    @Override
    public long solve() {
        long[][] grid = new long[21][21];

        for (int i = 0; i <= 20; i++) {
            grid[i][0] = 1;
            grid[0][i] = 1;
        }

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[20][20];
    }
}
