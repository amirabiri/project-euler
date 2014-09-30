package euler.solutions;

import euler.common.BaseSolution;

import java.util.Arrays;

public class _22 extends BaseSolution {
    private String[] names;

    @Override
    public void initialize() throws Exception {
        names = dataFileLines();
        Arrays.sort(names);
    }

    @Override
    public long solve() {
        long total_sum = 0;
        int pos = 1;

        for (String name : names) {
            int charSum = 0;
            for (int i = 0; i < name.length(); i++) {
                charSum += name.charAt(i) - 64;
            }
            total_sum += charSum * pos++;
        }

        return total_sum;
    }
}
