package euler.common;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumbersUtilsTests {

    @Test
    public void testGetDivisors() {
        int[] divisors = NumberUtils.getDivisors(220);
        Arrays.sort(divisors);

        final int[] EXPECTED = { 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 };
        assertThat(Arrays.equals(divisors, EXPECTED), is(true));
    }
}
