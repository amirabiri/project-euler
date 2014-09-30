package euler.solutions;

import euler.common.BaseSolution;

public class _2 extends BaseSolution {
    @Override
    public long solve() {
        int  a   = 1;
        int  b   = 2;
        long sum = 0;

        while (b < 4_000_000) {
            if (b % 2 == 0) {
                sum += b;
            }
            int tmp = a + b;
            a = b;
            b = tmp;
        }

        return sum;
    }
}
