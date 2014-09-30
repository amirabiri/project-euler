package euler.solutions;

import euler.common.BaseSolution;

public class _11 extends BaseSolution {

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
    private int[][] numbers;

    @Override
    public void initialize() throws Exception {
        numbers = dataFileIntMatrix();
    }

    @Override
    public long solve() {
        int max = 0;

        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 17; x++) {
                for (int[] dir : DIRS) {
                    int yDir = dir[0];
                    int xDir = dir[1];

                    if (yDir == -1 && y < 3)  continue;
                    if (yDir == 1  && y > 16) continue;

                    int p = check(x, y, xDir, yDir);
                    if (p > max) {
                        max = p;
                    }
                }
            }
        }

        return max;
    }

    private int check(int x, int y, int xDir, int yDir) {
        int product = 1;
        for (int i = 0; i < 4; i++) {
            product *= numbers[y][x];
            x += xDir;
            y += yDir;
        }
        return product;
    }
}
