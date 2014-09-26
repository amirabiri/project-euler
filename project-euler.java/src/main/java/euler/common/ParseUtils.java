package euler.common;

import com.google.common.base.Splitter;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class ParseUtils {
    public static int[][] parseIntMatrix(BufferedReader reader) throws Exception {
        List<int[]> rows = new ArrayList<int[]>();

        String line;
        while ((line = reader.readLine()) != null) {
            List<String> parts = Splitter.on(' ').splitToList(line);
            int[] elms = new int[parts.size()];
            int i = 0;
            for (String part : parts) {
                elms[i++] = Integer.parseInt(part);
            }
            rows.add(elms);
        }

        return rows.toArray(new int[rows.size()][]);
    }
}
