package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;

import static euler.common.NumberUtils.getDivisors;
import static euler.common.NumberUtils.sum;

public class _23 extends BaseSolution {
    TIntList  abundants;
    boolean[] isAbundants;

    @Override
    public Result solve() {
        findAbundants();

        long sum = 0;
        for (int n = 1; n <= 28123; n++) {
            if (!isAbundantSum(n)) {
                sum += n;
            }
        }

        return new Result(sum);
    }

    private void findAbundants() {
        abundants =  new TIntArrayList(10000);
        isAbundants = new boolean[28123];

        for (int num = 2; num <= 28123; num++) {
            if (sum(getDivisors(num)) > num) {
                abundants.add(num);
                isAbundants[num - 1] = true;
            }
        }
    }

    private boolean isAbundantSum(int n) {
        for (TIntIterator it = abundants.iterator(); it.hasNext();) {
            int abundant = it.next();
            if (abundant >= n) {
                return false;
            }
            if (isAbundants[n - abundant -1]) {
                return true;
            }
        }
        return false;
    }
}
