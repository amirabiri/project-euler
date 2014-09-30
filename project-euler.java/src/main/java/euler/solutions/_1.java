package euler.solutions;

import euler.common.BaseSolution;

public class _1 extends BaseSolution {

    @Override
    public long solve() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
