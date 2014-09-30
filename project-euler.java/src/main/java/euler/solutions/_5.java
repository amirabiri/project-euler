package euler.solutions;

import euler.common.BaseSolution;
import gnu.trove.iterator.TIntIntIterator;
import gnu.trove.map.TIntIntMap;
import gnu.trove.map.hash.TIntIntHashMap;

import static com.google.common.math.IntMath.pow;
import static euler.common.NumberUtils.getPrimeFactors;

public class _5 extends BaseSolution {

    @Override
    public long solve() {
        TIntIntMap superset = new TIntIntHashMap();

        for (int n = 2; n <= 20; n++) {
            TIntIntMap primeFactorsMap = reduceToMap(getPrimeFactors(n));

            for (TIntIntIterator it = primeFactorsMap.iterator(); it.hasNext();) {
                it.advance();
                int factor = it.key();
                int count  = it.value();
                int supersetCount = superset.get(factor);
                if (count > supersetCount) {
                    superset.put(factor, count);
                }
            }
        }

        int num = 1;
        for (TIntIntIterator it = superset.iterator(); it.hasNext();) {
            it.advance();
            int factor = it.key();
            int count  = it.value();
            num *= pow(factor, count);
        }

        return num;
    }

    private TIntIntMap reduceToMap(int[] numbers) {
        TIntIntMap ret = new TIntIntHashMap();
        for (int n : numbers) {
            ret.adjustOrPutValue(n, 1, 1);
        }
        return ret;
    }
}
