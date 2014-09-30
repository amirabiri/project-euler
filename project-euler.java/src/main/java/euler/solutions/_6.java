package euler.solutions;

import euler.common.BaseSolution;

public class _6 extends BaseSolution {
    @Override
    public long solve() {
        int sum = 0, sumSqrs = 0;

        for (int i = 1; i <= 100; i++) {
            sum     += i;
            sumSqrs += i * i;
        }

        return sum * sum - sumSqrs;
    }
}
