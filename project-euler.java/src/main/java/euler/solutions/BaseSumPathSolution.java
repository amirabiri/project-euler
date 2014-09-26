package euler.solutions;

import euler.common.BaseSolution;
import euler.common.ParseUtils;
import euler.common.Result;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;

public abstract class BaseSumPathSolution extends BaseSolution {
    private int[][] triangle;

    @Override
    public void initialize() throws Exception {
        triangle = ParseUtils.parseIntMatrix(openDataFile());
    }

    @Override
    public Result solve() {
        int[] bottom = triangle[triangle.length - 1];
        Path[] paths = new Path[bottom.length];
        for (int i = 0; i < bottom.length; i++) {
            paths[i] = new Path(bottom[i]);
        }

        for (int i = triangle.length - 2; i >= 0; i--) {
            Path[] next_paths = new Path[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                Path pathToTake = paths[j].sum > paths[j + 1].sum ? paths[j] : paths[j + 1];
                next_paths[j] = pathToTake.add(triangle[i][j]);
            }
            paths = next_paths;
        }

        return new Result(paths[0].sum);
    }

    private static class Path {
        public final int      sum;
        public final TIntList path;


        public Path(int num) {
            sum = num;
            path = new TIntArrayList();
            path.add(num);
        }

        private Path(int sum, TIntList path) {
            this.sum  = sum;
            this.path = path;
        }

        public Path add(int num) {
            TIntList newPath = new TIntArrayList(path);
            newPath.add(num);
            return new Path(sum + num, newPath);
        }
    }
}
