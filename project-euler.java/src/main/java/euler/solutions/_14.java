package euler.solutions;

import euler.common.BaseSolution;
import gnu.trove.list.TLongList;
import gnu.trove.list.array.TLongArrayList;

public class _14 extends BaseSolution {

    int[] termLengthCache;

    @Override
    public long solve() {
        termLengthCache = new int[1_000_000];

        int longest = 0, term = 0;

        for (int n = 1; n <= 1_000_000; n++) {
            int length = termLength(n);
            if (length > longest) {
                longest = length;
                term = n;
            }
        }

        return term;
    }

    int termLength(long number) {
        if (termLengthCache[(int)number - 1] == 0) {
            findTermLength(number);
        }

        return termLengthCache[(int)number - 1];
    }

    void findTermLength(long number) {
        TLongList path = new TLongArrayList();

        while (number != 1 && (number > 1_000_000 || termLengthCache[(int)number - 1] == 0)) {
            path.add(number);
            number = nextTerm(number);
        }

        if (number == 1) {
            setCache(path, 1);
        }
        else {
            setCache(path, termLengthCache[(int) number - 1]);
        }
    }

    long nextTerm(long n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        else {
            return 3 * n + 1;
        }
    }

    void setCache(TLongList path, int start) {
        for (int i = 0; i < path.size(); i++) {
            long number = path.get(i);
            if (number <= 1_000_000) {
                termLengthCache[(int)number - 1] = path.size() - i + start;
            }
        }
    }
}
