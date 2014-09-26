package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;

import static euler.common.NumberUtils.PrimesIterator;

public class _10 extends BaseSolution {

    @Override
    public Result solve() {
        long sum = 2 + 3 + 5;

        PrimesIterator primes = new PrimesIterator();
        int x = primes.next();
        while (x < 2_000_000) {
            sum += x;
            x = primes.next();
        }

        return new Result(sum);
    }
}
