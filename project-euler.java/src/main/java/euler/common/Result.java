package euler.common;

public class Result {
    public static enum Type {
        Integer, String
    }

    private final long   longResult;
    private final String stringResult;
    private final Type   type;

    public Result(long longResult) {
        this.longResult   = longResult;
        this.stringResult = null;
        this.type         = Type.Integer;
    }

    public Result(String stringResult) {
        this.longResult   = 0;
        this.stringResult = stringResult;
        this.type         = Type.String;
    }

    public long getLongResult() {
        return longResult;
    }

    public String getStringResult() {
        return stringResult;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        switch (type) {
            case Integer: return String.valueOf(longResult);
            case String:  return stringResult;
            default:      return null;
        }
    }
}
