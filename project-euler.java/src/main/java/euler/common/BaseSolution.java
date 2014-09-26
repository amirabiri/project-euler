package euler.common;

import java.io.BufferedReader;

public abstract class BaseSolution implements Solution {

    public void initialize() throws Exception {}

    public abstract Result solve();

    protected String dataFilename() {
        return getClass().getSimpleName().substring(1) + ".txt";
    }

    protected BufferedReader openDataFile() {
        return DataUtils.openDataFile(dataFilename());
    }

    protected String[] dataFileLines() {
        return DataUtils.dataFileLines(dataFilename());
    }

    protected String dataFileStringNoNewlines() {
        return DataUtils.dataFileStringNoNewlines(dataFilename());
    }

    protected int[][] dataFileIntMatrix() throws Exception {
        return ParseUtils.parseIntMatrix(openDataFile());
    }
}
