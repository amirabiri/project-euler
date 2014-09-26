package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;

import java.math.BigInteger;

import static com.google.common.collect.Iterables.toArray;
import static com.google.common.collect.Lists.transform;
import static java.math.BigInteger.ZERO;
import static java.util.Arrays.asList;

public class _13 extends BaseSolution {

    private BigInteger[] numbers;

    @Override
    public void initialize() throws Exception {
        numbers = toArray(transform(asList(dataFileLines()), BigInteger::new), BigInteger.class);
    }

    @Override
    public Result solve() {
        BigInteger sum = ZERO;
        for (BigInteger number : numbers) {
            sum = sum.add(number);
        }
        return new Result(sum.toString().substring(0, 10));
    }
}
