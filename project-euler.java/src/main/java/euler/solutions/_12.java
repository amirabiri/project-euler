package euler.solutions;

import euler.common.BaseSolution;

import static euler.common.NumberUtils.getDivisors;

public class _12 extends BaseSolution {

    @Override
    public long solve() {
        int number = 0;
        int term   = 0;
        while (true) {
            number++;
            term += number;
            if (getDivisors(term).length > 500) {
                return term;
            }
        }
    }
}
