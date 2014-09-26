package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;

import java.math.BigInteger;

public class _16 extends BaseSolution {

    @Override
    public Result solve() {
        String twoPow1000 = new BigInteger("2").pow(1000).toString();
        int sum = 0;
        for (int i = 0; i < twoPow1000.length(); i++) {
            sum += twoPow1000.charAt(i) - 48;
        }
        return new Result(sum);
    }
}
