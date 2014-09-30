package euler.solutions;

import euler.common.BaseSolution;
import euler.common.ParseUtils;

public abstract class BaseSumPathSolution extends BaseSolution {
    private int[][] triangle;

    @Override
    public void initialize() throws Exception {
        triangle = ParseUtils.parseIntMatrix(openDataFile());
    }

    @Override
    public long solve() {
        int[] paths = triangle[triangle.length - 1];

        for (int i = triangle.length - 2; i >= 0; i--) {
            int[] next_paths = new int[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                int pathToTake = paths[j] > paths[j + 1] ? paths[j] : paths[j + 1];
                next_paths[j] = pathToTake + triangle[i][j];
            }
            paths = next_paths;
        }

        return paths[0];
    }
}
