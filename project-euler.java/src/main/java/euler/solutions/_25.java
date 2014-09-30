package euler.solutions;

import euler.common.BaseSolution;

import java.math.BigInteger;

public class _25 extends BaseSolution {

    @Override
    public long solve() {
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

        return ord;
    }
}
