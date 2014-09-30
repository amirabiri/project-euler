package euler.solutions;

import euler.common.BaseSolution;

public class _3 extends BaseSolution {

    @Override
    public long solve() {
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
        return num;
    }
}
