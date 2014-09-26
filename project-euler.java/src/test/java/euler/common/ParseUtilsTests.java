package euler.common;

import org.junit.Test;

import static euler.common.DataUtils.openDataFile;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParseUtilsTests {

    @Test
    public void parseSimpleIntMatrix() throws Exception {
        int[][] matrix = ParseUtils.parseIntMatrix(openDataFile("int_matrix.txt"));
        assertThat(matrix[0][0], is(1));
        assertThat(matrix[0][1], is(2));
        assertThat(matrix[0][2], is(3));
        assertThat(matrix[2][3], is(10));
    }
}
