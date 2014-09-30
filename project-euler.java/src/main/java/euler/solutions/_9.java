package euler.solutions;

import euler.common.BaseSolution;

public class _9 extends BaseSolution {

    @Override
    public long solve() {
        for (int a = 1; a <= 998; a++) {
            for (int b = a + 1; b <= 999 - a; b++) {
                int c = 1000 - a - b;
                if (a * a + b * b == c * c) {
                    return a * b * c;
                }
            }
        }
        throw new RuntimeException("Failed to solve problem");
    }
}
