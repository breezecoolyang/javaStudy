package datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTimeTest {
    private static double doubleValue = 0;
    public static void main(String[] args) {

//     testTime();
//     testDateTimeFormatter();
        floatToDouble();
    }

    public static void testTime() {
        LocalDate dNow = LocalDate.now();
        System.out.println(dNow);
        LocalTime dTime = LocalTime.now();
        System.out.println(dTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    public static void testDateTimeFormatter() {
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("yyyy/LL/dd");
        System.out.println(df.format(LocalDate.now()));
    }

    public static void floatToDouble() {
        Float a = 16.199f;
        double c= a;
        System.out.println(a);
        testDouble(Double.parseDouble(a.toString()));
    }

    public static void testDouble(double value)
    {
        doubleValue = value;
        System.out.println(doubleValue);
    }

    public static void getAmericanTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(sdf.format(Calendar.getInstance().getTime()));
    }
}
