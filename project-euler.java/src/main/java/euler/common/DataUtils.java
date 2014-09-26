package euler.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    public static BufferedReader openDataFile(String filename) {
        InputStream stream = ParseUtils.class.getResourceAsStream("/" + filename);
        if (stream == null) {
            throw new RuntimeException("Cannot find data file (" + filename + ")");
        }
        return new BufferedReader(new InputStreamReader(stream));
    }

    public static String[] dataFileLines(String filename) {
        BufferedReader reader = openDataFile(filename);
        try {
            List<String> names = new ArrayList<>();
            for (;;) {
                String line = reader.readLine();
                if (line == null)
                    break;
                names.add(line);
            }
            return names.toArray(new String[names.size()]);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to read data file (" + filename + ")", e);
        }
    }

    public static String dataFileStringNoNewlines(String filename) {
        BufferedReader reader = openDataFile(filename);
        try {
            StringBuilder str = new StringBuilder();
            for (;;) {
                String line = reader.readLine();
                if (line == null)
                    break;
                str.append(line);
            }
            return str.toString();
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to read data file (" + filename + ")", e);
        }
    }
}
