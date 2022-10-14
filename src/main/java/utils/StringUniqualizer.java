package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class StringUniqualizer {
    public static String createUniqueString(String data) {
        return data + dataGenerator();
    }

    public static String dataGenerator() {
        return new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(new Date());
    }

    public static String futureTime() {
        String data = dataGenerator();
        String newData = data.substring(0, 10);
        return LocalDate.parse(newData).plusDays(1).toString();
    }
}