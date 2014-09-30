package euler.solutions;

import euler.common.BaseSolution;

public class _4 extends BaseSolution {

    @Override
    public long solve() {
        int leftSide = 999;
        int num = makePalindrome(leftSide);

        while (!check(num)) {
            leftSide--;
            num = makePalindrome(leftSide);
        }

        return num;
    }

    int makePalindrome(int num) {
        int c = num % 10;
        int b = (num / 10) % 10;
        int a = num / 100;

        return num * 1000 + c * 100 + b * 10 + a;
    }

    boolean check(int num) {
        if (num % 11 != 0) return false;

        for (int fac = 999; fac >= 900; fac--) {
            if (num % fac == 0 && num / fac < 1000) {
                return true;
            }
        }

        return false;
    }
}
