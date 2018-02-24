package UnnecessaryObject;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestClass {

    private final Date birthDate;
    private TestClass(){
        Calendar gmt = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmt.set(1950,1,0,0,0);
        birthDate = gmt.getTime();

    }
    public static TestClass getInstance(){

        return new TestClass();
    }
    public boolean isBabyBoomer(){
        //칼렌더가 생성비용이 높아 일단 예제 그대로 사용!
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) <0;
    }
}