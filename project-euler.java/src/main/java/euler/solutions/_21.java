package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.hash.TIntIntHashMap;

import static euler.common.NumberUtils.getDivisors;
import static euler.common.NumberUtils.sum;
import static gnu.trove.impl.Constants.DEFAULT_LOAD_FACTOR;

public class _21 extends BaseSolution {
    private TIntIntHashMap divisorSums;

    @Override
    public Result solve() {
        TIntList amicables = new TIntArrayList();
        divisorSums = new TIntIntHashMap(10000, DEFAULT_LOAD_FACTOR, -1, -1);
        divisorSums.put(1, 0);

        for (int n = 2; n <= 10000; n++) {
            int sum = sumDivisors(n);

            if (sum > 10000 || sum <= n) continue;

            if (sumDivisors(sum) == n) {
                amicables.add(n);
                amicables.add(sum);
            }
        }

        divisorSums = null;
        return new Result(amicables.sum());
    }

    int sumDivisors(int n)
    {
        int sum = divisorSums.get(n);
        if (sum == -1) {
            sum = sum(getDivisors(n));
            divisorSums.put(n, sum);
        }
        return sum;
    }
}
