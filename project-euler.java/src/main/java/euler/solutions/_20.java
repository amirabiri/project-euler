package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;

import java.math.BigInteger;

public class _20 extends BaseSolution {

    @Override
    public Result solve() {
        BigInteger num = new BigInteger("1");

        for (int i = 2; i <= 100; i++) {
            num = num.multiply(new BigInteger(String.valueOf(i)));
        }

        int sum = 0;
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++) {
            char chr = numStr.charAt(i);
            sum += chr - 48;
        }

        return new Result(sum);
    }
}
