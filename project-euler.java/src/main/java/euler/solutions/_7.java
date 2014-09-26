package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;

import static euler.common.NumberUtils.PrimesIterator;

public class _7 extends BaseSolution {

    @Override
    public Result solve() {
        PrimesIterator primes = new PrimesIterator();
        for (int i = 4; i < 10001; i++)
            primes.next();

        return new Result(primes.next());
    }
}
