package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;

public class _24 extends BaseSolution {

    private TIntList digits;

    @Override
    public Result solve() {
        digits = new TIntArrayList(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        int n   = 1_000_000;
        int fac = 362880; // factorial(9)
        String ret = "";

        for (int i = 9; i > 0; i--) {
            int ord = (n / fac);
            n %= fac;
            if (n == 0) {
                ord--;
                n = fac;
            }
            fac /= i;
            int digit = nthDigit(ord);
            ret += digit;
        }

        ret += digits.get(0);

        return new Result(ret);
    }


    private int nthDigit(int idx)
    {
        int digit = digits.get(idx);
        digits.removeAt(idx);
        return digit;
    }
}
