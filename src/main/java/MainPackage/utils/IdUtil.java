package MainPackage.utils;

import java.sql.Timestamp;

public class IdUtil {
    public static Timestamp timestamp;

    public static Timestamp timestampGenerator() {
        if (timestamp == null) {
            timestamp = new Timestamp(System.currentTimeMillis());
        }
        return timestamp;
    }
    public static long IdGenerator(){
        Timestamp ts = timestampGenerator();
        long value = ts.getTime();
        return value;
    }
}
