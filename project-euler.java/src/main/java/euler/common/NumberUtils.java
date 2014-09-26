package euler.common;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;

import static com.google.common.math.IntMath.*;
import static java.math.RoundingMode.*;

public class NumberUtils {

    public static int[] getDivisors(int n) {
        TIntList divisors = new TIntArrayList();
        divisors.add(1);
        int sqr = sqrt(n, HALF_UP);

        for (int x = 2; x <= sqr; x++) {
            if (n % x == 0) {
                divisors.add(x);
                int opp = n / x;
                if (opp != x) {
                    divisors.add(opp);
                }
            }
        }

        return divisors.toArray();
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return sum;
    }

    private static int[] P235 = { 2, 3, 5 };
    private static int[] P30  = { 1, 7, 11, 13, 17, 19, 23, 29 };

    public static class ProbablePrimesGenerator {
        private int i = 0;
        private int k = 0;

        public int next() {
            i++;
            if (i == P30.length) {
                k++;
                i = 0;
            }
            return k * 30 + P30[i];
        }
    }

    public static ProbablePrimesGenerator probablePrimes() {
        return new ProbablePrimesGenerator();
    }

    public static class PrimesIterator {
        private TIntList                primes         = new TIntArrayList(new int[] { 2, 3, 5 });
        private ProbablePrimesGenerator probablePrimes = new ProbablePrimesGenerator();

        public int next() {
            int number = probablePrimes.next();
            while (!isPrime(number)) {
                number = probablePrimes.next();
            }
            primes.add(number);
            return number;
        }

        private boolean isPrime(int number) {
            int sqr = sqrt(number, HALF_UP);
            for (TIntIterator it = primes.iterator(); it.hasNext();) {
                int p = it.next();
                if (p > sqr)         break;
                if (number % p == 0) return false;
            }
            return true;
        }
    }

    public static PrimesIterator primes() {
        return new PrimesIterator();
    }

    public static int[] getPrimeFactors(int number) {
        TIntList factors = new TIntArrayList();

        for (int i : P235) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }

        ProbablePrimesGenerator probablePrimes = probablePrimes();
        int x = probablePrimes.next();
        while (x <= number / x) {
            while (number % x == 0) {
                factors.add(x);
                number /= x;
            }
            x = probablePrimes.next();
        }

        if (number > 1) {
            factors.add(number);
        }

        return factors.toArray();
    }
}
