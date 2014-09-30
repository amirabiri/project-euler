package euler.solutions;

import euler.common.BaseSolution;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;

public class _26 extends BaseSolution {

    @Override
    public long solve() {
        int maxD = 0, maxLen = 0;

        for (int d = 1; d <= 1000; d++) {
            int length = unitFractionCycleLength(d);
            if (length > maxLen) {
                maxLen = length;
                maxD = d;
            }
        }

        return maxD;
    }

    private int unitFractionCycleLength(int d) {
        int result = 1;
        TIntList prev = new TIntArrayList();

        while (result != 0)
        {
            result = result * 10 % d;
            int idx = prev.indexOf(result);

            if (idx != -1) {
                return (prev.size() - idx);
            }

            prev.add(result);
        }

        return 0;
    }
}
