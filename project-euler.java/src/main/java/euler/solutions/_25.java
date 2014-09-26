package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;

import java.math.BigInteger;

public class _25 extends BaseSolution {

    @Override
    public Result solve() {
        BigInteger a = new BigInteger("1"),
                   b = new BigInteger("1");
        long ord = 2;

        while (true) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
            ord++;
            if (c.toString().length() == 1000) {
                break;
            }
        }

        return new Result(ord);
    }
}
