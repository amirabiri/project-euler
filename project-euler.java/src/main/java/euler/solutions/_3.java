package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;

public class _3 extends BaseSolution {

    @Override
    public Result solve() {
        long num = 600851475143L;
        int  fac = 2;
        while (fac < num) {
            if (num % fac == 0) {
                num /= fac;
            }
            else {
                fac++;
            }
        }
        return new Result(num);
    }
}
