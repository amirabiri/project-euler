package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;

public class _6 extends BaseSolution {
    @Override
    public Result solve() {
        int sum = 0, sumSqrs = 0;

        for (int i = 1; i <= 100; i++) {
            sum     += i;
            sumSqrs += i * i;
        }

        return new Result(sum * sum - sumSqrs);
    }
}
