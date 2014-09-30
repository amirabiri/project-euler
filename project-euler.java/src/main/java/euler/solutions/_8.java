package euler.solutions;

import euler.common.BaseSolution;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;

public class _8 extends BaseSolution {
    private int[] digits;

    @Override
    public void initialize() throws Exception {
        TIntList digitsList = new TIntArrayList();
        for (char chr : dataFileStringNoNewlines().toCharArray()) {
            digitsList.add((int)chr - 48);
        }
        digits = digitsList.toArray();
    }

    @Override
    public long solve() {
        long max = 0;
        for (int i = 0; i < digits.length - 12; i++) {
            long p = 1;
            for (int j = 0; j < 13; j++) {
                p *= digits[i + j];
            }

            if (p > max) {
                max = p;
            }
        }

        return max;
    }
}
